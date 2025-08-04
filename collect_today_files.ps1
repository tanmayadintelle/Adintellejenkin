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
$today = (Get-Date).Date

foreach ($folder in $folders) {
    $fullFolderPath = Join-Path $basePath $folder

    if (Test-Path $fullFolderPath) {
        # Get all files recursively where CreationTime or LastWriteTime is today
        $filesToday = Get-ChildItem -Path $fullFolderPath -Recurse -File | Where-Object {
            ($_.CreationTime.Date -eq $today) -or ($_.LastWriteTime.Date -eq $today)
        }
        
        foreach ($file in $filesToday) {
            # Calculate relative path from base folder
            $relativePath = $file.FullName.Substring($fullFolderPath.Length).TrimStart('\')
            $destination = Join-Path $tempFolder (Join-Path $folder $relativePath)
            $destinationDir = Split-Path $destination

            if (!(Test-Path $destinationDir)) {
                New-Item -ItemType Directory -Path $destinationDir -Force | Out-Null
            }

            Copy-Item -Path $file.FullName -Destination $destination -Force
        }
    }
}

if (!(Test-Path "zips")) {
    New-Item -ItemType Directory -Path "zips" | Out-Null
}

Compress-Archive -Path "$tempFolder\*" -DestinationPath "zips\TodaysOutput.zip" -Force
