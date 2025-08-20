package domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Classe Bootcamp que gerencia todo o sistema.
 * Demonstra ABSTRAÇÃO, ENCAPSULAMENTO e relacionamentos entre classes.
 */
public class Bootcamp {
    
    private String nome;
    private String descricao;
    private final LocalDate dataInicio = LocalDate.now();
    private final LocalDate dataFim = dataInicio.plusDays(45);
    private Set<Dev> devsInscritos = new HashSet<>();
    private Set<Conteudo> conteudos = new LinkedHashSet<>();
    
    // Construtor
    public Bootcamp(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }
    
    // Métodos de comportamento
    public void adicionarConteudo(Conteudo conteudo) {
        this.conteudos.add(conteudo);
    }
    
    public void removerConteudo(Conteudo conteudo) {
        this.conteudos.remove(conteudo);
    }
    
    public void listarConteudos() {
        System.out.println("\n=== CONTEÚDOS DO BOOTCAMP ===");
        System.out.println("Nome: " + nome);
        System.out.println("Descrição: " + descricao);
        System.out.println("Data Início: " + dataInicio);
        System.out.println("Data Fim: " + dataFim);
        System.out.println("Total de Conteúdos: " + conteudos.size());
        System.out.println("Total de Devs Inscritos: " + devsInscritos.size());
        
        System.out.println("\n--- Conteúdos Disponíveis ---");
        for (Conteudo conteudo : conteudos) {
            System.out.println(conteudo);
        }
    }
    
    public void listarDevsInscritos() {
        System.out.println("\n=== DEVS INSCRITOS ===");
        if (devsInscritos.isEmpty()) {
            System.out.println("Nenhum dev inscrito ainda.");
        } else {
            for (Dev dev : devsInscritos) {
                System.out.println(dev);
            }
        }
    }
    
    // Getters e Setters
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public LocalDate getDataInicio() {
        return dataInicio;
    }
    
    public LocalDate getDataFim() {
        return dataFim;
    }
    
    public Set<Dev> getDevsInscritos() {
        return devsInscritos;
    }
    
    public void setDevsInscritos(Set<Dev> devsInscritos) {
        this.devsInscritos = devsInscritos;
    }
    
    public Set<Conteudo> getConteudos() {
        return conteudos;
    }
    
    public void setConteudos(Set<Conteudo> conteudos) {
        this.conteudos = conteudos;
    }
    
    @Override
    public String toString() {
        return "Bootcamp{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                ", devsInscritos=" + devsInscritos.size() +
                ", conteudos=" + conteudos.size() +
                '}';
    }
}
