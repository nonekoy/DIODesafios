package domain;

/**
 * Classe Curso que herda de Conteudo.
 * Demonstra o conceito de HERANÇA e POLIMORFISMO.
 */
public class Curso extends Conteudo {
    
    private int cargaHoraria;
    
    // Construtor
    public Curso(String titulo, String descricao, int cargaHoraria) {
        super(titulo, descricao); // Chama o construtor da classe pai
        this.cargaHoraria = cargaHoraria;
    }
    
    // Implementação do método abstrato da classe pai
    @Override
    public double calcularXp() {
        // XP baseado na carga horária
        return XP_PADRAO * cargaHoraria;
    }
    
    // Getter e Setter específico da classe
    public int getCargaHoraria() {
        return cargaHoraria;
    }
    
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    
    @Override
    public String toString() {
        return "Curso{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", dataCriacao=" + getDataCriacao() +
                ", cargaHoraria=" + cargaHoraria +
                ", xp=" + calcularXp() +
                '}';
    }
}
