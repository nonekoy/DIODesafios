import java.util.Scanner;

public class HeroiClassificador {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Variáveis para armazenar nome e XP do herói
        String nomeHeroi;
        int xpHeroi;
        
        System.out.println("=== CLASSIFICADOR DE NÍVEL DE HERÓI ===");
        System.out.println();
        
        // Entrada de dados
        System.out.print("Digite o nome do herói: ");
        nomeHeroi = scanner.nextLine();
        
        System.out.print("Digite a quantidade de experiência (XP) do herói: ");
        xpHeroi = scanner.nextInt();
        
        // Estrutura de decisão para classificar o nível
        String nivel = "";
        
        if (xpHeroi < 1000) {
            nivel = "Ferro";
        } else if (xpHeroi >= 1001 && xpHeroi <= 2000) {
            nivel = "Bronze";
        } else if (xpHeroi >= 2001 && xpHeroi <= 5000) {
            nivel = "Prata";
        } else if (xpHeroi >= 5001 && xpHeroi <= 7000) {
            nivel = "Ouro";
        } else if (xpHeroi >= 7001 && xpHeroi <= 8000) {
            nivel = "Platina";
        } else if (xpHeroi >= 8001 && xpHeroi <= 9000) {
            nivel = "Ascendente";
        } else if (xpHeroi >= 9001 && xpHeroi <= 10000) {
            nivel = "Imortal";
        } else if (xpHeroi >= 10001) {
            nivel = "Radiante";
        }
        
        // Saída da mensagem
        System.out.println();
        System.out.println("O Herói de nome **" + nomeHeroi + "** está no nível de **" + nivel + "**");
        
        // Informações adicionais
        System.out.println();
        System.out.println("=== INFORMAÇÕES DO HERÓI ===");
        System.out.println("Nome: " + nomeHeroi);
        System.out.println("XP: " + xpHeroi);
        System.out.println("Nível: " + nivel);
        
        scanner.close();
    }
}
