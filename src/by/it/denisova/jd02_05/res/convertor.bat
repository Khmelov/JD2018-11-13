FOR %%I In (*.txt) DO (
"D:\java\bin\native2ascii.exe" -encoding utf-8 %%I %%~nI.properties
)

