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
        # Get all subfolders created today under the folder
        $createdTodayFolders = Get-ChildItem -Path $fullFolderPath -Directory | Where-Object {
            $_.CreationTime.Date -eq $today
        }

        foreach ($subfolder in $createdTodayFolders) {
            # Copy everything under this subfolder
            $files = Get-ChildItem -Path $subfolder.FullName -Recurse -File
            foreach ($file in $files) {
                # Preserve folder structure
                $relativePath = $file.FullName.Substring($basePath.Length).TrimStart("\")
                $destination = Join-Path $tempFolder $relativePath
                $destinationDir = Split-Path $destination

                if (!(Test-Path $destinationDir)) {
                    New-Item -ItemType Directory -Path $destinationDir -Force | Out-Null
                }

                Copy-Item -Path $file.FullName -Destination $destination -Force
            }
        }
    }
}

# Zip the collected files
if (!(Test-Path "zips")) {
    New-Item -ItemType Directory -Path "zips" | Out-Null
}
Compress-Archive -Path "$tempFolder\*" -DestinationPath "zips\TodaysOutput.zip" -Force
