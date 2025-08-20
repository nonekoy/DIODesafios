package domain;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Classe Dev que representa um desenvolvedor.
 * Demonstra ENCAPSULAMENTO e relacionamentos com outras classes.
 */
public class Dev {
    
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();
    
    // Construtor
    public Dev(String nome) {
        this.nome = nome;
    }
    
    // Métodos de comportamento
    public void inscreverBootcamp(Bootcamp bootcamp) {
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }
    
    public void progredir() {
        if (!conteudosInscritos.isEmpty()) {
            Conteudo conteudo = conteudosInscritos.iterator().next();
            conteudosInscritos.remove(conteudo);
            conteudosConcluidos.add(conteudo);
            System.out.println("Parabéns! Você concluiu: " + conteudo.getTitulo());
        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }
    }
    
    public double calcularTotalXp() {
        return conteudosConcluidos.stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }
    
    // Getters e Setters
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }
    
    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }
    
    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }
    
    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }
    
    @Override
    public String toString() {
        return "Dev{" +
                "nome='" + nome + '\'' +
                ", conteudosInscritos=" + conteudosInscritos.size() +
                ", conteudosConcluidos=" + conteudosConcluidos.size() +
                ", xp=" + calcularTotalXp() +
                '}';
    }
}
