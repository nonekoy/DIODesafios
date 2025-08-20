package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de teste para demonstrar como testar as funcionalidades básicas.
 * Para executar: mvn test
 */
public class ConteudoTest {
    
    private Curso curso;
    private Mentoria mentoria;
    
    @BeforeEach
    void setUp() {
        curso = new Curso("Java Básico", "Fundamentos de Java", 8);
        mentoria = new Mentoria("Mentoria POO", "Conceitos de POO", 
            java.time.LocalDateTime.now().plusDays(7));
    }
    
    @Test
    void testCursoCriacao() {
        assertNotNull(curso);
        assertEquals("Java Básico", curso.getTitulo());
        assertEquals("Fundamentos de Java", curso.getDescricao());
        assertEquals(8, curso.getCargaHoraria());
    }
    
    @Test
    void testMentoriaCriacao() {
        assertNotNull(mentoria);
        assertEquals("Mentoria POO", mentoria.getTitulo());
        assertEquals("Conceitos de POO", mentoria.getDescricao());
    }
    
    @Test
    void testCalculoXpCurso() {
        // XP = XP_PADRAO * cargaHoraria = 10 * 8 = 80
        assertEquals(80.0, curso.calcularXp(), 0.01);
    }
    
    @Test
    void testCalculoXpMentoria() {
        // XP = XP_PADRAO + 20 = 10 + 20 = 30
        assertEquals(30.0, mentoria.calcularXp(), 0.01);
    }
    
    @Test
    void testHeranca() {
        // Verifica se Curso e Mentoria são instâncias de Conteudo
        assertTrue(curso instanceof Conteudo);
        assertTrue(mentoria instanceof Conteudo);
    }
    
    @Test
    void testPolimorfismo() {
        // Demonstra polimorfismo - tratando ambos como Conteudo
        Conteudo[] conteudos = {curso, mentoria};
        
        double xpTotal = 0;
        for (Conteudo conteudo : conteudos) {
            xpTotal += conteudo.calcularXp();
        }
        
        assertEquals(110.0, xpTotal, 0.01); // 80 + 30
    }
}
