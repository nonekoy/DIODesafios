package domain;

import java.time.LocalDateTime;

/**
 * Classe Mentoria que herda de Conteudo.
 * Demonstra o conceito de HERANÇA e POLIMORFISMO.
 */
public class Mentoria extends Conteudo {
    
    private LocalDateTime data;
    
    // Construtor
    public Mentoria(String titulo, String descricao, LocalDateTime data) {
        super(titulo, descricao); // Chama o construtor da classe pai
        this.data = data;
    }
    
    // Implementação do método abstrato da classe pai
    @Override
    public double calcularXp() {
        // XP fixo para mentorias
        return XP_PADRAO + 20d;
    }
    
    // Getter e Setter específico da classe
    public LocalDateTime getData() {
        return data;
    }
    
    public void setData(LocalDateTime data) {
        this.data = data;
    }
    
    @Override
    public String toString() {
        return "Mentoria{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", dataCriacao=" + getDataCriacao() +
                ", data=" + data +
                ", xp=" + calcularXp() +
                '}';
    }
}
