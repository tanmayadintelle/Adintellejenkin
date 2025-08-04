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
        Write-Host "Checking folder: $folder"
        $items = Get-ChildItem -Path $fullFolderPath -Recurse -Force
        foreach ($item in $items) {
            $creationDate = $item.CreationTime.Date
            $writeDate = $item.LastWriteTime.Date
            $isToday = ($creationDate -eq $today) -or ($writeDate -eq $today)

            Write-Host ("{0} | Created: {1} | Modified: {2} | Matches Today? {3}" -f $item.FullName, $creationDate, $writeDate, $isToday)

            if ($isToday) {
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
    } else {
        Write-Host "Folder not found: $folder"
    }
}

if (!(Test-Path "zips")) {
    New-Item -ItemType Directory -Path "zips" | Out-Null
}

Compress-Archive -Path "$tempFolder\*" -DestinationPath "zips\TodaysOutput.zip" -Force
Write-Host "Archive created at zips\TodaysOutput.zip"
