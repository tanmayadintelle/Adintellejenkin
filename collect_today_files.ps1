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

# ✅ Set cutoff time to today at 6:00 AM
$cutoffTime = (Get-Date).Date.AddHours(6)
$basePath = (Get-Location).Path

foreach ($folder in $folders) {
    $fullFolderPath = Join-Path $basePath $folder

    if (Test-Path $fullFolderPath) {
        $items = Get-ChildItem -Path $fullFolderPath -Recurse -Force

        foreach ($item in $items) {
            $relativePath = $item.FullName.Substring($basePath.Length).TrimStart('\')
            $destination = Join-Path $tempFolder $relativePath
            $destinationDir = Split-Path $destination

            # ✅ Include only items modified or created after 6:00 AM today
            if ($item.CreationTime -ge $cutoffTime -or $item.LastWriteTime -ge $cutoffTime) {
                if ($item.PSIsContainer) {
                    if (!(Test-Path $destination)) {
                        Copy-Item -Path $item.FullName -Destination $destination -Recurse -Force
                    }
                } else {
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
