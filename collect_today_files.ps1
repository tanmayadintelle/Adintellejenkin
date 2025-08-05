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

$cutoffTime = (Get-Date).Date  # Midnight today
$basePath = (Get-Location).Path

foreach ($folder in $folders) {
    $fullFolderPath = Join-Path $basePath $folder

    if (Test-Path $fullFolderPath) {
        $items = Get-ChildItem -Path $fullFolderPath -Recurse -Force

        foreach ($item in $items) {
            $relativePath = $item.FullName.Substring($basePath.Length).TrimStart('\')
            $destination = Join-Path $tempFolder $relativePath
            $destinationDir = Split-Path $destination

            if ($item.PSIsContainer) {
                # Copy folder only if it was created or modified today
                if ($item.CreationTime -ge $cutoffTime -or $item.LastWriteTime -ge $cutoffTime) {
                    if (!(Test-Path $destination)) {
                        Copy-Item -Path $item.FullName -Destination $destination -Recurse -Force
                    }
                }
            } else {
                # Copy file only if it was created or modified today
                if ($item.CreationTime -ge $cutoffTime -or $item.LastWriteTime -ge $cutoffTime) {
                    if (!(Test-Path $destinationDir)) {
                        New-Item -ItemType Directory -Path $destinationDir -Force | Out-Null
                    }
                    Copy-Item $item.FullName -Destination $destination -Force
                }
            }
        }
    }
}

if (!(Test-Path "zips")) {
    New-Item -ItemType Directory -Path "zips" | Out-Null
}

Compress-Archive -Path "$tempFolder\*" -DestinationPath "zips\TodaysOutput.zip" -Force
