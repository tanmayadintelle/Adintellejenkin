$today = (Get-Date).Date

foreach ($folder in $folders) {
    $fullFolderPath = Join-Path $basePath $folder

    if (Test-Path $fullFolderPath) {
        # Get all subfolders created today
        $subfoldersToday = Get-ChildItem -Path $fullFolderPath -Directory -Recurse | Where-Object { $_.CreationTime.Date -eq $today }

        # Also include the main folder if it itself was created today
        if ((Get-Item $fullFolderPath).CreationTime.Date -eq $today) {
            $subfoldersToday += Get-Item $fullFolderPath
        }

        # Copy all files inside these folders regardless of file timestamps
        foreach ($subfolder in $subfoldersToday) {
            $files = Get-ChildItem -Path $subfolder.FullName -File -Recurse
            foreach ($file in $files) {
                $relativePath = $file.FullName.Substring($basePath.Length).TrimStart("\")
                $destination = Join-Path $tempFolder $relativePath
                $destinationDir = Split-Path $destination

                if (!(Test-Path $destinationDir)) {
                    New-Item -ItemType Directory -Path $destinationDir -Force | Out-Null
                }

                Copy-Item -Path $file.FullName -Destination $destination -Force
            }
        }

        # Also copy files modified or created today directly inside $fullFolderPath (not in newly created folders)
        $filesToday = Get-ChildItem -Path $fullFolderPath -File -Recurse | Where-Object {
            ($_.CreationTime.Date -eq $today) -or ($_.LastWriteTime.Date -eq $today)
        }
        foreach ($file in $filesToday) {
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
