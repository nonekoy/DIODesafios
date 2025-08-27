package com.dio.board.service;

import com.dio.board.domain.Task;
import com.dio.board.domain.TaskPriority;
import com.dio.board.domain.TaskStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TaskService {
    
    /**
     * Salva uma nova tarefa
     */
    Task saveTask(Task task);
    
    /**
     * Atualiza uma tarefa existente
     */
    Task updateTask(Long id, Task task);
    
    /**
     * Busca uma tarefa por ID
     */
    Optional<Task> findTaskById(Long id);
    
    /**
     * Lista todas as tarefas
     */
    List<Task> findAllTasks();
    
    /**
     * Remove uma tarefa
     */
    void deleteTask(Long id);
    
    /**
     * Busca tarefas por status
     */
    List<Task> findTasksByStatus(TaskStatus status);
    
    /**
     * Busca tarefas por prioridade
     */
    List<Task> findTasksByPriority(TaskPriority priority);
    
    /**
     * Busca tarefas vencidas
     */
    List<Task> findOverdueTasks();
    
    /**
     * Busca tarefas por título
     */
    List<Task> findTasksByTitle(String title);
    
    /**
     * Atualiza o status de uma tarefa
     */
    Task updateTaskStatus(Long id, TaskStatus status);
    
    /**
     * Atualiza a prioridade de uma tarefa
     */
    Task updateTaskPriority(Long id, TaskPriority priority);
    
    /**
     * Obtém estatísticas das tarefas
     */
    TaskStatistics getTaskStatistics();
}
