@echo off
cd /d "%~dp0"

echo Compilando proyecto...
if not exist bin mkdir bin
xcopy /E /I /Y src\resources bin\resources >nul 2>&1

set SOURCES=
for /R src %%f in (*.java) do set SOURCES=!SOURCES! "%%f"

setlocal enabledelayedexpansion
set SOURCES=
for /R src %%f in (*.java) do set SOURCES=!SOURCES! "%%f"
javac -encoding ISO-8859-1 -cp src -d bin %SOURCES%

if %ERRORLEVEL% NEQ 0 (
    echo Error de compilacion.
    pause
    exit /b 1
)

echo Iniciando juego...
java -cp bin com.resident.init.Main
