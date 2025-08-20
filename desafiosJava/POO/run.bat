@echo off
echo ========================================
echo    BOOTCAMP JAVA - POO
echo ========================================
echo.

echo Compilando o projeto...
call mvn clean compile

if %ERRORLEVEL% NEQ 0 (
    echo.
    echo ERRO: Falha na compilacao!
    pause
    exit /b 1
)

echo.
echo Compilacao concluida com sucesso!
echo.

echo Executando o projeto...
call mvn exec:java -Dexec.mainClass="Main"

echo.
echo Projeto executado!
pause
