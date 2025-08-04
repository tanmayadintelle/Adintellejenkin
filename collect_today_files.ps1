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
    Write-Host "`n--- Processing folder: $folder ---"

    $fullFolderPath = Join-Path $basePath $folder

    if (-not (Test-Path $fullFolderPath)) {
        Write-Host "✗ Folder does not exist: $fullFolderPath"
        continue
    }

    $items = Get-ChildItem -Path $fullFolderPath -Recurse -Force

    foreach ($item in $items) {
        $createdToday = $item.CreationTime.Date -eq $today
        $modifiedToday = $item.LastWriteTime.Date -eq $today
        $isMatch = $createdToday -or $modifiedToday

        $flag = if ($isMatch) { "✔" } else { "✗" }
        Write-Host ("$flag {0,-80} Created: {1}  Modified: {2}" -f $item.FullName, $item.CreationTime.Date, $item.LastWriteTime.Date)

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

# Create zip output
if (!(Test-Path "zips")) {
    New-Item -ItemType Directory -Path "zips" | Out-Null
}

Compress-Archive -Path "$tempFolder\*" -DestinationPath "zips\TodaysOutput.zip" -Force
