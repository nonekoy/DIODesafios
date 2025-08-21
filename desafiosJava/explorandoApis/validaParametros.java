import java.util.Scanner;

public class ValidaParametrosAPI {

    public static void main(String[] args) {
        // Inicializa o Scanner para ler a entrada
        Scanner scanner = new Scanner(System.in);
        
        // Solicita a entrada da URL
        String url = scanner.nextLine();
        
        // Chama o método para validar a URL
        String resultado = validarParametros(url);

        // Exibe o resultado
        System.out.println(resultado);
        
        // Fecha o scanner
        scanner.close();
    }

    // Método para validar os parametros da URL
    public static String validarParametros(String url) {
        // Valida se a URL começa com '?'
        if (!url.startsWith("?")) {
            return "Parametros invalidos";
        }

        // Remove o '?' da URL para analisar os parametros
        url = url.substring(1);

        // Divide a URL pelos '&' para obter cada parametro
        String[] parametros = url.split("&");

        // TODO: Verifique cada parametro individualmente:
        for (String parametro : parametros) {
            // TODO: Divida cada parametro pelo '=':
            String[] chaveValor = parametro.split("=");
            

            // TODO: Verifica se há exatamente um '=':
            if (chaveValor.length != 2) {
                return "Parametros invalidos";
            }

            // TODO: Valideo nome do parametro (alfanumerico):
            if (!chaveValor[0].matches("[a-zA-Z0-9]+")) {
                return "Parametros invalidos";
            }

            // Valida o valor do parametro (alfanumerico ou numero, ou valores como e-mail)
            // Permite caracteres especiais como @ e . para casos como email
            if (!chaveValor[1].matches("[a-zA-Z0-9@.]+") && !chaveValor[1].matches("\\d+")) {
                return "Parametros invalidos";
            }
        }

        // Se passar em todas as validacoes, os parametros sao validos
        return "Parametros validos";
    }
}
