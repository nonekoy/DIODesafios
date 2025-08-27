package com.dio.board.repository;

import com.dio.board.domain.Task;
import com.dio.board.domain.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    
    /**
     * Busca tarefas por status
     */
    List<Task> findByStatus(TaskStatus status);
    
    /**
     * Busca tarefas por prioridade
     */
    List<Task> findByPriority(com.dio.board.domain.TaskPriority priority);
    
    /**
     * Busca tarefas que vencem até uma data específica
     */
    List<Task> findByDueDateBefore(LocalDateTime date);
    
    /**
     * Busca tarefas por título (contendo o texto)
     */
    List<Task> findByTitleContainingIgnoreCase(String title);
    
    /**
     * Busca tarefas por status e prioridade
     */
    List<Task> findByStatusAndPriority(TaskStatus status, com.dio.board.domain.TaskPriority priority);
    
    /**
     * Busca tarefas vencidas (dueDate < now)
     */
    @Query("SELECT t FROM Task t WHERE t.dueDate < :now AND t.status != 'DONE'")
    List<Task> findOverdueTasks(@Param("now") LocalDateTime now);
    
    /**
     * Conta tarefas por status
     */
    long countByStatus(TaskStatus status);
    
    /**
     * Busca tarefas ordenadas por data de criação (mais recentes primeiro)
     */
    List<Task> findAllByOrderByCreatedAtDesc();
    
    /**
     * Busca tarefas ordenadas por prioridade (urgente primeiro)
     */
    List<Task> findAllByOrderByPriorityDesc();
}
