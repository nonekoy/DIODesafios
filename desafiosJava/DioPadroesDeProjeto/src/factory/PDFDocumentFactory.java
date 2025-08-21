package factory;

/**
 * Fábrica concreta para documentos PDF
 */
public class PDFDocumentFactory extends DocumentFactory {
    
    @Override
    public Document createDocument(String title, String author) {
        System.out.println("📄 Criando documento PDF...");
        return new PDFDocument(title, author);
    }
    
    @Override
    protected void processSpecificFeatures(Document document) {
        if (document instanceof PDFDocument) {
            PDFDocument pdfDoc = (PDFDocument) document;
            pdfDoc.compress();
        }
    }
}
