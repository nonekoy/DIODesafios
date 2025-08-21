package factory;

/**
 * Fábrica de documentos usando Factory Method
 */
public abstract class DocumentFactory {
    
    /**
     * Método factory abstrato
     */
    public abstract Document createDocument(String title, String author);
    
    /**
     * Método template que usa o factory method
     */
    public final void processDocument(String title, String author) {
        System.out.println("\n🏭 FÁBRICA DE DOCUMENTOS");
        System.out.println("================================");
        
        // Cria o documento usando o factory method
        Document document = createDocument(title, author);
        
        // Processa o documento
        document.createContent();
        document.displayInfo();
        document.save();
        document.print();
        
        // Processamento específico do tipo de documento
        processSpecificFeatures(document);
        
        System.out.println("================================");
    }
    
    /**
     * Hook method para processamento específico
     */
    protected abstract void processSpecificFeatures(Document document);
}
