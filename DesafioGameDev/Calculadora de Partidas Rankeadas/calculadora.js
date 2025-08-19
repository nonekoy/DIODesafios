// Calculadora de Partidas Rankeadas
// Desafio JavaScript com funções gets() e print() da DIO

// Função que recebe vitórias e derrotas e retorna o nível do jogador
function calcularNivel(vitorias, derrotas) {
    // Calcula o saldo de vitórias (vitórias - derrotas)
    const saldoVitorias = vitorias - derrotas;
    
    // Determina o nível baseado na quantidade de vitórias
    let nivel;
    
    if (vitorias < 10) {
        nivel = "Ferro";
    } else if (vitorias >= 11 && vitorias <= 20) {
        nivel = "Bronze";
    } else if (vitorias >= 21 && vitorias <= 50) {
        nivel = "Prata";
    } else if (vitorias >= 51 && vitorias <= 80) {
        nivel = "Ouro";
    } else if (vitorias >= 81 && vitorias <= 90) {
        nivel = "Diamante";
    } else if (vitorias >= 91 && vitorias <= 100) {
        nivel = "Lendário";
    } else if (vitorias >= 101) {
        nivel = "Imortal";
    }
    
    // Retorna um objeto com saldo e nível
    return {
        saldo: saldoVitorias,
        nivel: nivel
    };
}

// Função principal que executa o programa
function main() {
    // Simula entrada de dados (em ambiente real seria gets())
    const vitorias = parseInt(gets());
    const derrotas = parseInt(gets());
    
    // Chama a função para calcular o nível
    const resultado = calcularNivel(vitorias, derrotas);
    
    // Exibe a mensagem de saída
    print("O Herói tem de saldo de **" + resultado.saldo + "** está no nível de **" + resultado.nivel + "**");
}

// Executa o programa
main();
