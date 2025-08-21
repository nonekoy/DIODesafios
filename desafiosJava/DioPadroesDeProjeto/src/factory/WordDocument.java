package factory;

/**
 * Implementação concreta de documento Word
 */
public class WordDocument extends Document {
    
    public WordDocument(String title, String author) {
        super(title, author);
    }
    
    @Override
    public void createContent() {
        System.out.println("📝 Criando conteúdo para documento Word...");
        this.content = "Conteúdo do documento Word: " + title + "\n" +
                      "Este é um documento Word criado por " + author + "\n" +
                      "Formato: DOCX (Microsoft Word)\n" +
                      "Características: Editável, formatação rica, compatível com Office";
        System.out.println("✅ Conteúdo Word criado com sucesso!");
    }
    
    @Override
    public void save() {
        System.out.println("💾 Salvando documento Word...");
        System.out.println("📁 Arquivo salvo como: " + title.replaceAll("\\s+", "_") + ".docx");
        System.out.println("✅ Documento Word salvo com sucesso!");
    }
    
    @Override
    public void print() {
        System.out.println("🖨️ Imprimindo documento Word...");
        System.out.println("📋 Enviando para impressora...");
        System.out.println("✅ Documento Word enviado para impressão!");
    }
    
    /**
     * Método específico para Word
     */
    public void spellCheck() {
        System.out.println("🔍 Verificando ortografia do documento Word...");
        System.out.println("✅ Verificação ortográfica concluída!");
        System.out.println("📊 Estatísticas: 0 erros encontrados");
    }
}
