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

$today = (Get-Date).Date
$basePath = (Get-Location).Path

foreach ($folder in $folders) {
    $fullFolderPath = Join-Path $basePath $folder

    if (Test-Path $fullFolderPath) {
        # Get all child items (files and folders) recursively
        $items = Get-ChildItem -Path $fullFolderPath -Recurse -Force

        foreach ($item in $items) {
            $relativePath = $item.FullName.Substring($basePath.Length).TrimStart('\')
            $destination = Join-Path $tempFolder $relativePath
            $destinationDir = Split-Path $destination

            # If folder (directory) created today - copy entire folder + contents
            if ($item.PSIsContainer -and $item.CreationTime.Date -eq $today) {
                # Copy whole folder with contents if not already copied
                if (!(Test-Path $destination)) {
                    Copy-Item -Path $item.FullName -Destination $destination -Recurse -Force
                }
            }
            # Else if file (not folder) created or modified today - copy file
            elseif (-not $item.PSIsContainer) {
                if (($item.CreationTime.Date -eq $today) -or ($item.LastWriteTime.Date -eq $today)) {
                    if (!(Test-Path $destinationDir)) {
                        New-Item -ItemType Directory -Path $destinationDir -Force | Out-Null
                    }
                    Copy-Item $item.FullName -Destination $destination -Force
                }
            }
        }
    }
}

# Create zip output folder if not exists
if (!(Test-Path "zips")) {
    New-Item -ItemType Directory -Path "zips" | Out-Null
}

Compress-Archive -Path "$tempFolder\*" -DestinationPath "zips\TodaysOutput.zip" -Force
