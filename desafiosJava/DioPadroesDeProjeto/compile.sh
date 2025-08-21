#!/bin/bash

echo "========================================"
echo " Compilando Padroes de Projeto Java"
echo "========================================"

echo
echo "Criando diretorio bin..."
mkdir -p bin

echo
echo "Compilando arquivos Java..."
javac -d bin src/**/*.java

if [ $? -eq 0 ]; then
    echo
    echo "✅ Compilacao concluida com sucesso!"
    echo
    echo "========================================"
    echo " Executando demonstracao..."
    echo "========================================"
    echo
    java -cp bin Main
else
    echo
    echo "❌ Erro na compilacao!"
    echo "Verifique se o Java esta instalado e no PATH"
fi

echo
echo "Pressione Enter para sair..."
read
