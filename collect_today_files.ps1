$folders = @(
    "BTLoutputs",
    "digitaloutputsvbf",
    "digitaloutputscbf",
    "pressoutput",
    "reports",
    "Masterscreenshots"
)

$tempFolder = "todays_files"
if (Test-Path $tempFolder) {
    Remove-Item $tempFolder -Recurse -Force
}
New-Item -ItemType Directory -Path $tempFolder | Out-Null

$basePath = (Get-Location).Path

foreach ($folder in $folders) {
    # Build the full path to the folder relative to current directory
    $fullFolderPath = Join-Path $basePath $folder

    if (Test-Path $fullFolderPath) {
        $folderItem = Get-Item $fullFolderPath
        Get-ChildItem -Path $fullFolderPath -Recurse -Force | Where-Object {
            (-not $_.PSIsContainer -and $_.LastWriteTime.Date -eq (Get-Date).Date) -or
            ($_.PSIsContainer -and $_.CreationTime.Date -eq (Get-Date).Date)
        } | ForEach-Object {
            # Calculate relative path from the folder root
            $relativePath = $_.FullName.Substring($folderItem.FullName.Length).TrimStart("\")
            $destination = Join-Path $tempFolder (Join-Path $folder $relativePath)
            $destinationDir = Split-Path $destination

            if (!(Test-Path $destinationDir)) {
                New-Item -ItemType Directory -Path $destinationDir -Force | Out-Null
            }

            if (-not $_.PSIsContainer) {
                Copy-Item $_.FullName -Destination $destination -Force
            }
        }
    }
}

if (!(Test-Path "zips")) {
    New-Item -ItemType Directory -Path "zips" | Out-Null
}

Compress-Archive -Path "$tempFolder\*" -DestinationPath "zips\TodaysOutput.zip" -Force
