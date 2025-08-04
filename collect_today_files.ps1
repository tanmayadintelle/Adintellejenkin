Write-Host "`n--- Processing folder: $folder ---"
$fullFolderPath = Join-Path (Get-Location) $folder
if (-not (Test-Path $fullFolderPath)) {
    Write-Host "✗ Folder does not exist: $fullFolderPath"
    continue
}
Get-ChildItem -Path $fullFolderPath -Recurse -Force | ForEach-Object {
    $isMatch = ($_.CreationTime.Date -eq (Get-Date).Date) -or ($_.LastWriteTime.Date -eq (Get-Date).Date)
    Write-Host ("{0} {1,-50} CT: {2:MM/dd/yyyy}  LW: {3:MM/dd/yyyy}"
        -f ($isMatch ? "✔" : "✗"),
           $_.FullName,
           $_.CreationTime,
           $_.LastWriteTime)
}
