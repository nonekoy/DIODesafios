#!/bin/bash

echo "========================================"
echo "    BOOTCAMP JAVA - POO"
echo "========================================"
echo

echo "Compilando o projeto..."
mvn clean compile

if [ $? -ne 0 ]; then
    echo
    echo "ERRO: Falha na compilacao!"
    exit 1
fi

echo
echo "Compilacao concluida com sucesso!"
echo

echo "Executando o projeto..."
mvn exec:java -Dexec.mainClass="Main"

echo
echo "Projeto executado!"
