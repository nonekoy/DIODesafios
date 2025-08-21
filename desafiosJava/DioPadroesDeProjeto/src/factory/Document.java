package factory;

/**
 * PADRÃO FACTORY METHOD - Padrão Criacional
 * 
 * PROBLEMA:
 * - Criar objetos sem especificar suas classes concretas
 * - Delegar a criação para subclasses
 * - Flexibilidade na criação de objetos relacionados
 * 
 * SOLUÇÃO:
 * - Interface ou classe abstrata para produtos
 * - Método factory abstrato na classe criadora
 * - Implementações concretas para cada tipo de produto
 * 
 * EXEMPLOS PRÁTICOS:
 * - Criação de diferentes tipos de documentos
 * - Criação de diferentes tipos de conexões
 * - Criação de diferentes tipos de UI components
 * 
 * VANTAGENS:
 * + Encapsula a lógica de criação
 * + Facilita extensão com novos tipos
 * + Reduz acoplamento entre classes
 * + Permite polimorfismo na criação
 * 
 * DESVANTAGENS:
 * - Pode criar muitas subclasses
 * - Pode complicar a hierarquia de classes
 * - Pode ser overkill para casos simples
 */
public abstract class Document {
    
    protected String title;
    protected String content;
    protected String author;
    
    public Document(String title, String author) {
        this.title = title;
        this.author = author;
        this.content = "";
    }
    
    /**
     * Método abstrato que deve ser implementado pelas subclasses
     */
    public abstract void createContent();
    
    /**
     * Método abstrato para salvar o documento
     */
    public abstract void save();
    
    /**
     * Método abstrato para imprimir o documento
     */
    public abstract void print();
    
    /**
     * Método comum para todas as implementações
     */
    public void displayInfo() {
        System.out.println("📄 Título: " + title);
        System.out.println("✍️ Autor: " + author);
        System.out.println("📝 Conteúdo: " + content);
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public String getContent() {
        return content;
    }
}
