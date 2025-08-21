package observer;

/**
 * Interface para observadores no padrão Observer
 */
public interface Observer {
    
    /**
     * Método chamado quando o estado do sujeito muda
     * @param state novo estado do sujeito
     */
    void update(String state);
    
    /**
     * Obtém o nome do observador para identificação
     * @return nome do observador
     */
    String getName();
}
