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
        $items = Get-ChildItem -Path $fullFolderPath -Recurse -Force
        foreach ($item in $items) {
            if (($item.CreationTime.Date -eq $today) -or ($item.LastWriteTime.Date -eq $today)) {
                # Calculate relative path from base folder
                $relativePath = $item.FullName.Substring($basePath.Length).TrimStart('\')
                $destination = Join-Path $tempFolder $relativePath
                $destinationDir = Split-Path $destination

                if (!(Test-Path $destinationDir)) {
                    New-Item -ItemType Directory -Path $destinationDir -Force | Out-Null
                }

                if (-not $item.PSIsContainer) {
                    Copy-Item $item.FullName -Destination $destination -Force
                }
            }
        }
    }
}

# Create zip output folder if not exist
if (!(Test-Path "zips")) {
    New-Item -ItemType Directory -Path "zips" | Out-Null
}

Compress-Archive -Path "$tempFolder\*" -DestinationPath "zips\TodaysOutput.zip" -Force
