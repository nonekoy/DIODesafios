package factory;

/**
 * Implementação concreta de documento PDF
 */
public class PDFDocument extends Document {
    
    public PDFDocument(String title, String author) {
        super(title, author);
    }
    
    @Override
    public void createContent() {
        System.out.println("📄 Criando conteúdo para documento PDF...");
        this.content = "Conteúdo do documento PDF: " + title + "\n" +
                      "Este é um documento PDF criado por " + author + "\n" +
                      "Formato: PDF (Portable Document Format)\n" +
                      "Características: Mantém formatação, não editável, universal";
        System.out.println("✅ Conteúdo PDF criado com sucesso!");
    }
    
    @Override
    public void save() {
        System.out.println("💾 Salvando documento PDF...");
        System.out.println("📁 Arquivo salvo como: " + title.replaceAll("\\s+", "_") + ".pdf");
        System.out.println("✅ Documento PDF salvo com sucesso!");
    }
    
    @Override
    public void print() {
        System.out.println("🖨️ Imprimindo documento PDF...");
        System.out.println("📋 Enviando para impressora...");
        System.out.println("✅ Documento PDF enviado para impressão!");
    }
    
    /**
     * Método específico para PDF
     */
    public void compress() {
        System.out.println("🗜️ Comprimindo documento PDF...");
        System.out.println("📉 Tamanho reduzido em 30%");
        System.out.println("✅ Compressão concluída!");
    }
}
