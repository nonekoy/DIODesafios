package factory;

/**
 * Fábrica concreta para documentos Word
 */
public class WordDocumentFactory extends DocumentFactory {
    
    @Override
    public Document createDocument(String title, String author) {
        System.out.println("📝 Criando documento Word...");
        return new WordDocument(title, author);
    }
    
    @Override
    protected void processSpecificFeatures(Document document) {
        if (document instanceof WordDocument) {
            WordDocument wordDoc = (WordDocument) document;
            wordDoc.spellCheck();
        }
    }
}
