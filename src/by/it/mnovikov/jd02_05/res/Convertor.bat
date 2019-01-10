FOR %%I In (*.txt) DO (
    native2ascii.exe -encoding UTF-8 %%I %%~nI.properties
)