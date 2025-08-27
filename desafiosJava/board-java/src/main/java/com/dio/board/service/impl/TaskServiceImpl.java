package com.dio.board.service.impl;

import com.dio.board.domain.Task;
import com.dio.board.domain.TaskPriority;
import com.dio.board.domain.TaskStatus;
import com.dio.board.repository.TaskRepository;
import com.dio.board.service.TaskService;
import com.dio.board.service.TaskStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    
    @Autowired
    private TaskRepository taskRepository;
    
    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }
    
    @Override
    public Task updateTask(Long id, Task task) {
        Optional<Task> existingTask = taskRepository.findById(id);
        if (existingTask.isPresent()) {
            Task updatedTask = existingTask.get();
            updatedTask.setTitle(task.getTitle());
            updatedTask.setDescription(task.getDescription());
            updatedTask.setStatus(task.getStatus());
            updatedTask.setPriority(task.getPriority());
            updatedTask.setDueDate(task.getDueDate());
            return taskRepository.save(updatedTask);
        }
        throw new RuntimeException("Tarefa não encontrada com ID: " + id);
    }
    
    @Override
    public Optional<Task> findTaskById(Long id) {
        return taskRepository.findById(id);
    }
    
    @Override
    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }
    
    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
    
    @Override
    public List<Task> findTasksByStatus(TaskStatus status) {
        return taskRepository.findByStatus(status);
    }
    
    @Override
    public List<Task> findTasksByPriority(TaskPriority priority) {
        return taskRepository.findByPriority(priority);
    }
    
    @Override
    public List<Task> findOverdueTasks() {
        return taskRepository.findOverdueTasks(LocalDateTime.now());
    }
    
    @Override
    public List<Task> findTasksByTitle(String title) {
        return taskRepository.findByTitleContainingIgnoreCase(title);
    }
    
    @Override
    public Task updateTaskStatus(Long id, TaskStatus status) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            Task updatedTask = task.get();
            updatedTask.setStatus(status);
            return taskRepository.save(updatedTask);
        }
        throw new RuntimeException("Tarefa não encontrada com ID: " + id);
    }
    
    @Override
    public Task updateTaskPriority(Long id, TaskPriority priority) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            Task updatedTask = task.get();
            updatedTask.setPriority(priority);
            return taskRepository.save(updatedTask);
        }
        throw new RuntimeException("Tarefa não encontrada com ID: " + id);
    }
    
    @Override
    public TaskStatistics getTaskStatistics() {
        long totalTasks = taskRepository.count();
        long todoTasks = taskRepository.countByStatus(TaskStatus.TODO);
        long inProgressTasks = taskRepository.countByStatus(TaskStatus.IN_PROGRESS);
        long reviewTasks = taskRepository.countByStatus(TaskStatus.REVIEW);
        long doneTasks = taskRepository.countByStatus(TaskStatus.DONE);
        long overdueTasks = taskRepository.findOverdueTasks(LocalDateTime.now()).size();
        
        double completionRate = totalTasks > 0 ? (double) doneTasks / totalTasks * 100 : 0;
        
        return new TaskStatistics(
            totalTasks,
            todoTasks,
            inProgressTasks,
            reviewTasks,
            doneTasks,
            overdueTasks,
            completionRate
        );
    }
}
