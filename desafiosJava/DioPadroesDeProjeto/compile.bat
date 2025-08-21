@echo off
echo ========================================
echo  Compilando Padroes de Projeto Java
echo ========================================

echo.
echo Criando diretorio bin...
if not exist bin mkdir bin

echo.
echo Compilando arquivos Java...
javac -d bin src/**/*.java

if %ERRORLEVEL% EQU 0 (
    echo.
    echo ✅ Compilacao concluida com sucesso!
    echo.
    echo ========================================
    echo  Executando demonstracao...
    echo ========================================
    echo.
    java -cp bin Main
) else (
    echo.
    echo ❌ Erro na compilacao!
    echo Verifique se o Java esta instalado e no PATH
)

echo.
echo Pressione qualquer tecla para sair...
pause > nul
