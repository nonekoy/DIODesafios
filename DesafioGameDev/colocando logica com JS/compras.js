// Desafios JavaScript na DIO têm funções "gets" e "print" acessíveis globalmente:
//- "gets" : lê UMA linha com dado(s) de entrada (inputs) do usuário;
//- "print" : imprime um texto de saída (output), pulando linha.

// Para converter os valores inseridos na entrada, utilizamos a função JavaScript parseInt() que converte a parte inicial da string em um número inteiro.
const saldoInicial = parseInt(gets());
const resultadoUltimoRound = gets();
const custoItem = parseInt(gets());

function decidirCompraOuEconomizar(saldoInicial, resultadoUltimoRound, custoItem) {
    let novoSaldo;

    // TODO: Implemente a lógica para ajustar o saldo de acordo com o resultado do último round
    if (resultadoUltimoRound === "ganhou") {
        novoSaldo = saldoInicial + (saldoInicial * 0.15);
    } else if (resultadoUltimoRound === "perdeu") {
        novoSaldo = saldoInicial + (saldoInicial * 0.05);
    } else if (resultadoUltimoRound === "bônus") {
        novoSaldo = saldoInicial + (saldoInicial * 0.20);
    } else {
        novoSaldo = saldoInicial;
    }

    // Utilizamos a função JavaScript Math.round() para arredondar um número para o inteiro mais próximo.
    novoSaldo = Math.round(novoSaldo);

    // TODO: Implemente a lógica para verificar se o saldo é suficiente para comprar o item
    if (novoSaldo >= custoItem) {
        print("Comprar");
    } else {
        print("Economizar");
    }
}

// TODO: Chame a função para imprimir o resultado
decidirCompraOuEconomizar(saldoInicial, resultadoUltimoRound, custoItem);
