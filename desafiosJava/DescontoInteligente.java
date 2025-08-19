import java.util.Scanner;
import java.text.DecimalFormat;

public class DescontoInteligente {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // TODO: Leia o valor original do produto:
        double valorOriginal = scanner.nextDouble();

        // TODO: Leia a porcentagem de desconto:
        double porcentagemDesconto = scanner.nextDouble();

        // TODO: Verifique se o desconto está dentro de um intervalo válido:
        if (porcentagemDesconto >= 0 && porcentagemDesconto <= 100) {
            // TODO: Calcule o valor final do produto:
            double valorFinal = valorOriginal * (1 - porcentagemDesconto / 100);

            // Formata e exibe o valor com duas casas decimais
            DecimalFormat df = new DecimalFormat("0.00");
            System.out.println(df.format(valorFinal));
        } else {
            System.out.println("Desconto invalido");
        }

        scanner.close();
    }
}
