package domain;

import java.time.LocalDate;

/**
 * Classe abstrata que representa um conteúdo do bootcamp.
 * Demonstra o conceito de ABSTRAÇÃO e HERANÇA.
 */
public abstract class Conteudo {
    
    // Atributos protegidos - demonstra ENCAPSULAMENTO
    protected static final double XP_PADRAO = 10d;
    
    private String titulo;
    private String descricao;
    private LocalDate dataCriacao;
    
    // Construtor
    public Conteudo(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataCriacao = LocalDate.now();
    }
    
    // Método abstrato - cada classe filha deve implementar
    public abstract double calcularXp();
    
    // Getters e Setters - demonstra ENCAPSULAMENTO
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public LocalDate getDataCriacao() {
        return dataCriacao;
    }
    
    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
    
    @Override
    public String toString() {
        return "Conteudo{" +
                "titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataCriacao=" + dataCriacao +
                '}';
    }
}
