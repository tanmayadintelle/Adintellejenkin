# collect_today_files.ps1

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

foreach ($folder in $folders) {
    if (Test-Path $folder) {
        Get-ChildItem -Path $folder -Recurse -Force |
	 Where-Object {
 	 ($_.PSIsContainer -and $_.CreationTime.Date -eq (Get-Date).Date) -or
 	 (-not $_.PSIsContainer -and $_.LastWriteTime.Date -eq (Get-Date).Date)
	  }

   	   ForEach-Object {
                $relativePath = $_.FullName.Substring((Get-Item $folder).FullName.Length).TrimStart("\")
                $destination = Join-Path $tempFolder (Join-Path $folder $relativePath)
                $destinationDir = Split-Path $destination
                if (!(Test-Path $destinationDir)) {
                    New-Item -ItemType Directory -Path $destinationDir -Force | Out-Null
                }
                Copy-Item $_.FullName -Destination $destination -Force
            }
    }
}

# Zip the collected files
if (!(Test-Path "zips")) {
    New-Item -ItemType Directory -Path "zips" | Out-Null
}
Compress-Archive -Path "$tempFolder\*" -DestinationPath "zips\TodaysOutput.zip" -Force
