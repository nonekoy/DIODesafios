package com.dio.board.controller;

import com.dio.board.domain.Task;
import com.dio.board.domain.TaskPriority;
import com.dio.board.domain.TaskStatus;
import com.dio.board.service.TaskService;
import com.dio.board.service.TaskStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class WebController {
    
    @Autowired
    private TaskService taskService;
    
    @GetMapping("/")
    public String index(Model model) {
        List<Task> allTasks = taskService.findAllTasks();
        TaskStatistics statistics = taskService.getTaskStatistics();
        
        model.addAttribute("tasks", allTasks);
        model.addAttribute("statistics", statistics);
        model.addAttribute("statuses", TaskStatus.values());
        model.addAttribute("priorities", TaskPriority.values());
        
        return "index";
    }
    
    @GetMapping("/board")
    public String board(Model model) {
        List<Task> todoTasks = taskService.findTasksByStatus(TaskStatus.TODO);
        List<Task> inProgressTasks = taskService.findTasksByStatus(TaskStatus.IN_PROGRESS);
        List<Task> reviewTasks = taskService.findTasksByStatus(TaskStatus.REVIEW);
        List<Task> doneTasks = taskService.findTasksByStatus(TaskStatus.DONE);
        
        model.addAttribute("todoTasks", todoTasks);
        model.addAttribute("inProgressTasks", inProgressTasks);
        model.addAttribute("reviewTasks", reviewTasks);
        model.addAttribute("doneTasks", doneTasks);
        model.addAttribute("statuses", TaskStatus.values());
        model.addAttribute("priorities", TaskPriority.values());
        
        return "board";
    }
    
    @GetMapping("/tasks/new")
    public String newTaskForm(Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("statuses", TaskStatus.values());
        model.addAttribute("priorities", TaskPriority.values());
        return "task-form";
    }
    
    @GetMapping("/tasks/{id}/edit")
    public String editTaskForm(@PathVariable Long id, Model model) {
        Task task = taskService.findTaskById(id).orElse(new Task());
        model.addAttribute("task", task);
        model.addAttribute("statuses", TaskStatus.values());
        model.addAttribute("priorities", TaskPriority.values());
        return "task-form";
    }
    
    @PostMapping("/tasks")
    public String saveTask(@ModelAttribute Task task) {
        taskService.saveTask(task);
        return "redirect:/board";
    }
    
    @PostMapping("/tasks/{id}")
    public String updateTask(@PathVariable Long id, @ModelAttribute Task task) {
        taskService.updateTask(id, task);
        return "redirect:/board";
    }
    
    @PostMapping("/tasks/{id}/delete")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/board";
    }
    
    @PostMapping("/tasks/{id}/status")
    public String updateTaskStatus(@PathVariable Long id, @RequestParam TaskStatus status) {
        taskService.updateTaskStatus(id, status);
        return "redirect:/board";
    }
}
