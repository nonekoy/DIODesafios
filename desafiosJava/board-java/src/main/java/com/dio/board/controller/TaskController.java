package com.dio.board.controller;

import com.dio.board.domain.Task;
import com.dio.board.domain.TaskPriority;
import com.dio.board.domain.TaskStatus;
import com.dio.board.service.TaskService;
import com.dio.board.service.TaskStatistics;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {
    
    @Autowired
    private TaskService taskService;
    
    @PostMapping
    public ResponseEntity<Task> createTask(@Valid @RequestBody Task task) {
        Task savedTask = taskService.saveTask(task);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.findAllTasks();
        return ResponseEntity.ok(tasks);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Optional<Task> task = taskService.findTaskById(id);
        return task.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @Valid @RequestBody Task task) {
        try {
            Task updatedTask = taskService.updateTask(id, task);
            return ResponseEntity.ok(updatedTask);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Task>> getTasksByStatus(@PathVariable TaskStatus status) {
        List<Task> tasks = taskService.findTasksByStatus(status);
        return ResponseEntity.ok(tasks);
    }
    
    @GetMapping("/priority/{priority}")
    public ResponseEntity<List<Task>> getTasksByPriority(@PathVariable TaskPriority priority) {
        List<Task> tasks = taskService.findTasksByPriority(priority);
        return ResponseEntity.ok(tasks);
    }
    
    @GetMapping("/overdue")
    public ResponseEntity<List<Task>> getOverdueTasks() {
        List<Task> tasks = taskService.findOverdueTasks();
        return ResponseEntity.ok(tasks);
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<Task>> searchTasksByTitle(@RequestParam String title) {
        List<Task> tasks = taskService.findTasksByTitle(title);
        return ResponseEntity.ok(tasks);
    }
    
    @PatchMapping("/{id}/status")
    public ResponseEntity<Task> updateTaskStatus(@PathVariable Long id, @RequestParam TaskStatus status) {
        try {
            Task updatedTask = taskService.updateTaskStatus(id, status);
            return ResponseEntity.ok(updatedTask);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PatchMapping("/{id}/priority")
    public ResponseEntity<Task> updateTaskPriority(@PathVariable Long id, @RequestParam TaskPriority priority) {
        try {
            Task updatedTask = taskService.updateTaskPriority(id, priority);
            return ResponseEntity.ok(updatedTask);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/statistics")
    public ResponseEntity<TaskStatistics> getTaskStatistics() {
        TaskStatistics statistics = taskService.getTaskStatistics();
        return ResponseEntity.ok(statistics);
    }
}
