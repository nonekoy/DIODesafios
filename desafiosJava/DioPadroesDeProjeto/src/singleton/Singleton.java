package singleton;

/**
 * PADRÃO SINGLETON - Padrão Criacional
 * 
 * PROBLEMA:
 * - Garantir que uma classe tenha apenas uma instância
 * - Fornecer um ponto de acesso global a essa instância
 * - Controlar o acesso concorrente à instância única
 * 
 * SOLUÇÃO:
 * - Construtor privado para impedir instanciação externa
 * - Instância estática privada
 * - Método público estático para acessar a instância
 * - Sincronização para thread-safety (opcional)
 * 
 * EXEMPLOS PRÁTICOS:
 * - Logger do sistema
 * - Configurações globais
 * - Conexão com banco de dados
 * - Cache compartilhado
 * 
 * VANTAGENS:
 * + Garante uma única instância
 * + Acesso global controlado
 * + Lazy initialization possível
 * 
 * DESVANTAGENS:
 * - Pode dificultar testes unitários
 * - Pode criar acoplamento global
 * - Violação do princípio de responsabilidade única
 */
public class Singleton {
    
    // Instância única estática
    private static Singleton instance;
    
    // Construtor privado - impede instanciação externa
    private Singleton() {
        System.out.println("Singleton criado! Esta é a única instância.");
    }
    
    /**
     * Método público para acessar a instância única
     * Implementa lazy initialization (criação sob demanda)
     */
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
    
    /**
     * Método de exemplo para demonstrar o funcionamento
     */
    public void doSomething() {
        System.out.println("Singleton executando ação...");
        System.out.println("Hash da instância: " + this.hashCode());
    }
    
    /**
     * Versão thread-safe usando synchronized
     * Útil em ambientes multi-thread
     */
    public static synchronized Singleton getThreadSafeInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
