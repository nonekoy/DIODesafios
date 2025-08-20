import domain.*;

import java.time.LocalDateTime;

/**
 * Classe principal que demonstra todos os conceitos de POO em ação.
 * 
 * CONCEITOS DEMONSTRADOS:
 * 1. ABSTRAÇÃO - Classes representam entidades do mundo real
 * 2. ENCAPSULAMENTO - Atributos privados com getters/setters
 * 3. HERANÇA - Curso e Mentoria herdam de Conteudo
 * 4. POLIMORFISMO - Tratamento polimórfico de Conteudo
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("🚀 BOOTCAMP JAVA - DEMONSTRAÇÃO POO 🚀");
        System.out.println("========================================\n");
        
        // 1. CRIANDO O BOOTCAMP (ABSTRAÇÃO)
        System.out.println("1️⃣ CRIANDO O BOOTCAMP");
        Bootcamp bootcamp = new Bootcamp("Java Developer", 
            "Bootcamp completo de Java com foco em POO");
        System.out.println("✅ Bootcamp criado: " + bootcamp.getNome());
        
        // 2. CRIANDO CURSOS (HERANÇA)
        System.out.println("\n2️⃣ CRIANDO CURSOS");
        Curso curso1 = new Curso("Java Básico", "Fundamentos da linguagem Java", 8);
        Curso curso2 = new Curso("Java Intermediário", "Conceitos avançados de Java", 12);
        Curso curso3 = new Curso("Java Avançado", "Técnicas avançadas e padrões", 16);
        
        System.out.println("✅ Curso criado: " + curso1.getTitulo() + " - XP: " + curso1.calcularXp());
        System.out.println("✅ Curso criado: " + curso2.getTitulo() + " - XP: " + curso2.calcularXp());
        System.out.println("✅ Curso criado: " + curso3.getTitulo() + " - XP: " + curso3.calcularXp());
        
        // 3. CRIANDO MENTORIAS (HERANÇA)
        System.out.println("\n3️⃣ CRIANDO MENTORIAS");
        Mentoria mentoria1 = new Mentoria("Mentoria Java POO", 
            "Tire suas dúvidas sobre Programação Orientada a Objetos", 
            LocalDateTime.now().plusDays(7));
        Mentoria mentoria2 = new Mentoria("Mentoria Projeto Final", 
            "Acompanhamento do projeto final do bootcamp", 
            LocalDateTime.now().plusDays(30));
        
        System.out.println("✅ Mentoria criada: " + mentoria1.getTitulo() + " - XP: " + mentoria1.calcularXp());
        System.out.println("✅ Mentoria criada: " + mentoria2.getTitulo() + " - XP: " + mentoria2.calcularXp());
        
        // 4. ADICIONANDO CONTEÚDOS AO BOOTCAMP
        System.out.println("\n4️⃣ ADICIONANDO CONTEÚDOS AO BOOTCAMP");
        bootcamp.adicionarConteudo(curso1);
        bootcamp.adicionarConteudo(curso2);
        bootcamp.adicionarConteudo(curso3);
        bootcamp.adicionarConteudo(mentoria1);
        bootcamp.adicionarConteudo(mentoria2);
        System.out.println("✅ Todos os conteúdos foram adicionados ao bootcamp");
        
        // 5. CRIANDO DEVS
        System.out.println("\n5️⃣ CRIANDO DESENVOLVEDORES");
        Dev dev1 = new Dev("João Silva");
        Dev dev2 = new Dev("Maria Santos");
        Dev dev3 = new Dev("Pedro Costa");
        
        System.out.println("✅ Dev criado: " + dev1.getNome());
        System.out.println("✅ Dev criado: " + dev2.getNome());
        System.out.println("✅ Dev criado: " + dev3.getNome());
        
        // 6. INSCREVENDO DEVS NO BOOTCAMP
        System.out.println("\n6️⃣ INSCREVENDO DEVS NO BOOTCAMP");
        dev1.inscreverBootcamp(bootcamp);
        dev2.inscreverBootcamp(bootcamp);
        dev3.inscreverBootcamp(bootcamp);
        System.out.println("✅ Todos os devs foram inscritos no bootcamp");
        
        // 7. DEMONSTRANDO PROGRESSO DOS DEVS
        System.out.println("\n7️⃣ DEMONSTRANDO PROGRESSO DOS DEVS");
        
        // Dev 1 progride em alguns conteúdos
        System.out.println("\n--- " + dev1.getNome() + " ---");
        dev1.progredir(); // Conclui Java Básico
        dev1.progredir(); // Conclui Java Intermediário
        System.out.println("XP Total: " + dev1.calcularTotalXp());
        
        // Dev 2 progride em todos os conteúdos
        System.out.println("\n--- " + dev2.getNome() + " ---");
        dev2.progredir(); // Conclui Java Básico
        dev2.progredir(); // Conclui Java Intermediário
        dev2.progredir(); // Conclui Java Avançado
        dev2.progredir(); // Conclui Mentoria Java POO
        dev2.progredir(); // Conclui Mentoria Projeto Final
        System.out.println("XP Total: " + dev2.calcularTotalXp());
        
        // Dev 3 não progride
        System.out.println("\n--- " + dev3.getNome() + " ---");
        System.out.println("XP Total: " + dev3.calcularTotalXp());
        
        // 8. DEMONSTRANDO POLIMORFISMO
        System.out.println("\n8️⃣ DEMONSTRANDO POLIMORFISMO");
        System.out.println("Listando todos os conteúdos de forma polimórfica:");
        
        // POLIMORFISMO: tratando Curso e Mentoria como Conteudo
        for (Conteudo conteudo : bootcamp.getConteudos()) {
            System.out.println("📚 " + conteudo.getTitulo() + " - XP: " + conteudo.calcularXp());
        }
        
        // 9. EXIBINDO ESTADO FINAL
        System.out.println("\n9️⃣ ESTADO FINAL DO BOOTCAMP");
        bootcamp.listarConteudos();
        bootcamp.listarDevsInscritos();
        
        // 10. RESUMO DOS CONCEITOS DE POO
        System.out.println("\n🎯 RESUMO DOS CONCEITOS DE POO DEMONSTRADOS:");
        System.out.println("✅ ABSTRAÇÃO: Classes representam entidades reais (Bootcamp, Dev, Curso, Mentoria)");
        System.out.println("✅ ENCAPSULAMENTO: Atributos privados com acesso controlado via getters/setters");
        System.out.println("✅ HERANÇA: Curso e Mentoria herdam de Conteudo");
        System.out.println("✅ POLIMORFISMO: Tratamento uniforme de diferentes tipos de conteúdo");
        
        System.out.println("\n🚀 PROJETO CONCLUÍDO COM SUCESSO! 🚀");
        System.out.println("Todos os pilares da Programação Orientada a Objetos foram demonstrados!");
        
        // BONUS: CONCEITOS AVANÇADOS
        System.out.println("\n" + "=".repeat(60));
        System.out.println("🎁 BÔNUS: CONCEITOS AVANÇADOS DE POO");
        System.out.println("=".repeat(60));
        
        // Criar devs de exemplo para demonstrar conceitos avançados
        List<Dev> devsExemplo = ExemplosAvancados.criarDevsExemplo();
        
        // Simular progresso para alguns devs
        Bootcamp bootcampExemplo = new Bootcamp("POO Avançado", "Conceitos avançados de POO");
        Curso cursoExemplo = new Curso("Java Avançado", "Técnicas avançadas", 20);
        Mentoria mentoriaExemplo = new Mentoria("Mentoria Avançada", "Dúvidas avançadas", LocalDateTime.now().plusDays(5));
        
        bootcampExemplo.adicionarConteudo(cursoExemplo);
        bootcampExemplo.adicionarConteudo(mentoriaExemplo);
        
        // Dev 1 progride
        devsExemplo.get(0).inscreverBootcamp(bootcampExemplo);
        devsExemplo.get(0).progredir();
        devsExemplo.get(0).progredir();
        
        // Dev 2 progride um pouco
        devsExemplo.get(1).inscreverBootcamp(bootcampExemplo);
        devsExemplo.get(1).progredir();
        
        // Dev 3 não progride
        devsExemplo.get(2).inscreverBootcamp(bootcampExemplo);
        
        // Dev 4 progride muito
        devsExemplo.get(3).inscreverBootcamp(bootcampExemplo);
        devsExemplo.get(3).progredir();
        devsExemplo.get(3).progredir();
        
        // Demonstrar conceitos avançados
        ExemplosAvancados.demonstrarConceitosAvancados(devsExemplo);
        
        System.out.println("\n🎉 PROJETO COMPLETO FINALIZADO! 🎉");
        System.out.println("Todos os conceitos básicos e avançados de POO foram demonstrados!");
    }
}
