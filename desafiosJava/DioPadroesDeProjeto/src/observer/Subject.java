package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * PADRÃO OBSERVER - Padrão Comportamental
 * 
 * PROBLEMA:
 * - Objetos precisam ser notificados sobre mudanças de estado
 * - Acoplamento forte entre objeto observado e observadores
 * - Dificuldade em manter sincronização entre objetos relacionados
 * 
 * SOLUÇÃO:
 * - Interface comum para observadores
 * - Mecanismo de inscrição e cancelamento
 * - Notificação automática quando estado muda
 * 
 * EXEMPLOS PRÁTICOS:
 * - Sistema de notificações
 * - Eventos de interface gráfica
 * - Sistema de mensagens
 * - Monitoramento de recursos
 * 
 * VANTAGENS:
 * + Baixo acoplamento entre objetos
 * + Fácil adição/remoção de observadores
 * + Notificação automática
 * + Suporte a múltiplos observadores
 * 
 * DESVANTAGENS:
 * - Pode causar notificações em cascata
 * - Observadores podem não ser notificados na ordem esperada
 * - Pode causar vazamentos de memória se não for bem gerenciado
 */
public abstract class Subject {
    
    private List<Observer> observers = new ArrayList<>();
    private String state;
    
    /**
     * Adiciona um observador à lista
     */
    public void attach(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
            System.out.println("👁️ Observador adicionado: " + observer.getName());
        }
    }
    
    /**
     * Remove um observador da lista
     */
    public void detach(Observer observer) {
        if (observers.remove(observer)) {
            System.out.println("🚫 Observador removido: " + observer.getName());
        }
    }
    
    /**
     * Notifica todos os observadores sobre mudança de estado
     */
    public void notifyObservers() {
        System.out.println("📢 Notificando " + observers.size() + " observador(es)...");
        for (Observer observer : observers) {
            observer.update(state);
        }
    }
    
    /**
     * Altera o estado e notifica os observadores
     */
    public void setState(String newState) {
        this.state = newState;
        System.out.println("🔄 Estado alterado para: " + newState);
        notifyObservers();
    }
    
    /**
     * Obtém o estado atual
     */
    public String getState() {
        return state;
    }
    
    /**
     * Obtém o número de observadores
     */
    public int getObserverCount() {
        return observers.size();
    }
}
