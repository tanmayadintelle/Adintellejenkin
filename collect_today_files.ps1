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
            $isMatch = ($item.CreationTime.Date -eq $today) -or ($item.LastWriteTime.Date -eq $today)
            $flag = if ($isMatch) { "✔" } else { "✗" }
            Write-Host "$flag $($item.FullName) - Created: $($item.CreationTime) - Modified: $($item.LastWriteTime)"

            if ($isMatch) {
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

if (!(Test-Path "zips")) {
    New-Item -ItemType Directory -Path "zips" | Out-Null
}

Compress-Archive -Path "$tempFolder\*" -DestinationPath "zips\TodaysOutput.zip" -Force
