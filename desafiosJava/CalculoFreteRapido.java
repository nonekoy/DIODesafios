import java.util.Scanner;

public class CalculoFreteRapido {
  
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // TODO: Leia o peso em quilos:
        double peso = scanner.nextDouble();

        // TODO: Leia o valor do frete por quilo:
        double valorPorQuilo = scanner.nextDouble();

        // TODO: Calcule o valor total do frete:
        double valorTotal = peso * valorPorQuilo;

        // TODO: Exiba o valor formatado com duas casas decimais:
        System.out.printf("%.2f%n", valorTotal);

        scanner.close();
    }
}
