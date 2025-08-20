package domain;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Classe que demonstra conceitos mais avançados de POO:
 * - Interfaces
 * - Enums
 * - Coleções avançadas
 * - Streams
 * - Comparators
 */
public class ExemplosAvancados {
    
    // ENUM - demonstra um tipo enumerado
    public enum NivelDev {
        INICIANTE("Iniciante", 0),
        JUNIOR("Júnior", 100),
        PLENO("Pleno", 300),
        SENIOR("Sênior", 600),
        ESPECIALISTA("Especialista", 1000);
        
        private final String descricao;
        private final int xpMinimo;
        
        NivelDev(String descricao, int xpMinimo) {
            this.descricao = descricao;
            this.xpMinimo = xpMinimo;
        }
        
        public String getDescricao() { return descricao; }
        public int getXpMinimo() { return xpMinimo; }
        
        public static NivelDev getNivelPorXp(double xp) {
            for (NivelDev nivel : values()) {
                if (xp >= nivel.xpMinimo) {
                    continue;
                }
                return nivel;
            }
            return ESPECIALISTA;
        }
    }
    
    // INTERFACE - demonstra contrato que deve ser implementado
    public interface Avaliador {
        double avaliar(Dev dev);
        String getComentario(Dev dev);
    }
    
    // CLASSE que implementa a interface
    public static class AvaliadorPorXp implements Avaliador {
        @Override
        public double avaliar(Dev dev) {
            return dev.calcularTotalXp();
        }
        
        @Override
        public String getComentario(Dev dev) {
            double xp = avaliar(dev);
            NivelDev nivel = NivelDev.getNivelPorXp(xp);
            return String.format("%s é um dev %s com %.1f XP", 
                dev.getNome(), nivel.getDescricao(), xp);
        }
    }
    
    // CLASSE que implementa a interface de forma diferente
    public static class AvaliadorPorProgresso implements Avaliador {
        @Override
        public double avaliar(Dev dev) {
            int totalInscritos = dev.getConteudosInscritos().size();
            int totalConcluidos = dev.getConteudosConcluidos().size();
            
            if (totalInscritos == 0) return 0.0;
            return (double) totalConcluidos / totalInscritos * 100;
        }
        
        @Override
        public String getComentario(Dev dev) {
            double progresso = avaliar(dev);
            if (progresso >= 80) return dev.getNome() + " é muito dedicado!";
            if (progresso >= 50) return dev.getNome() + " está progredindo bem.";
            return dev.getNome() + " precisa se dedicar mais.";
        }
    }
    
    // MÉTODOS ESTÁTICOS para demonstrar funcionalidades
    public static void demonstrarConceitosAvancados(List<Dev> devs) {
        System.out.println("\n🔬 CONCEITOS AVANÇADOS DE POO");
        System.out.println("================================\n");
        
        // 1. USO DE ENUMS
        System.out.println("1️⃣ USO DE ENUMS");
        for (NivelDev nivel : NivelDev.values()) {
            System.out.printf("Nível: %s - XP Mínimo: %d%n", 
                nivel.getDescricao(), nivel.getXpMinimo());
        }
        
        // 2. POLIMORFISMO COM INTERFACES
        System.out.println("\n2️⃣ POLIMORFISMO COM INTERFACES");
        Avaliador avaliadorXp = new AvaliadorPorXp();
        Avaliador avaliadorProgresso = new AvaliadorPorProgresso();
        
        for (Dev dev : devs) {
            System.out.println("\n--- " + dev.getNome() + " ---");
            System.out.println("Avaliação por XP: " + avaliadorXp.getComentario(dev));
            System.out.println("Avaliação por Progresso: " + avaliadorProgresso.getComentario(dev));
        }
        
        // 3. STREAMS E LAMBDAS
        System.out.println("\n3️⃣ STREAMS E LAMBDAS");
        System.out.println("Devs ordenados por XP (decrescente):");
        devs.stream()
            .sorted((d1, d2) -> Double.compare(d2.calcularTotalXp(), d1.calcularTotalXp()))
            .forEach(dev -> System.out.printf("- %s: %.1f XP%n", 
                dev.getNome(), dev.calcularTotalXp()));
        
        // 4. FILTRAGEM E AGRUPAMENTO
        System.out.println("\n4️⃣ FILTRAGEM E AGRUPAMENTO");
        Map<NivelDev, List<Dev>> devsPorNivel = devs.stream()
            .collect(Collectors.groupingBy(dev -> 
                NivelDev.getNivelPorXp(dev.calcularTotalXp())));
        
        devsPorNivel.forEach((nivel, listaDevs) -> {
            System.out.printf("Nível %s (%d devs):%n", 
                nivel.getDescricao(), listaDevs.size());
            listaDevs.forEach(dev -> 
                System.out.printf("  - %s (%.1f XP)%n", 
                    dev.getNome(), dev.calcularTotalXp()));
        });
        
        // 5. ESTATÍSTICAS
        System.out.println("\n5️⃣ ESTATÍSTICAS");
        DoubleSummaryStatistics stats = devs.stream()
            .mapToDouble(Dev::calcularTotalXp)
            .summaryStatistics();
        
        System.out.printf("XP Total: %.1f%n", stats.getSum());
        System.out.printf("XP Médio: %.1f%n", stats.getAverage());
        System.out.printf("XP Máximo: %.1f%n", stats.getMax());
        System.out.printf("XP Mínimo: %.1f%n", stats.getMin());
        
        // 6. COMPARATORS PERSONALIZADOS
        System.out.println("\n6️⃣ COMPARATORS PERSONALIZADOS");
        System.out.println("Devs ordenados por nome:");
        devs.stream()
            .sorted(Comparator.comparing(Dev::getNome))
            .forEach(dev -> System.out.printf("- %s%n", dev.getNome()));
        
        System.out.println("\nDevs ordenados por progresso (conteúdos concluídos):");
        devs.stream()
            .sorted(Comparator.comparing(dev -> dev.getConteudosConcluidos().size()))
            .forEach(dev -> System.out.printf("- %s: %d conteúdos concluídos%n", 
                dev.getNome(), dev.getConteudosConcluidos().size()));
    }
    
    // MÉTODO para criar uma lista de devs de exemplo
    public static List<Dev> criarDevsExemplo() {
        List<Dev> devs = new ArrayList<>();
        
        Dev dev1 = new Dev("Ana Silva");
        Dev dev2 = new Dev("Bruno Costa");
        Dev dev3 = new Dev("Carla Santos");
        Dev dev4 = new Dev("Diego Lima");
        
        devs.add(dev1);
        devs.add(dev2);
        devs.add(dev3);
        devs.add(dev4);
        
        return devs;
    }
}
