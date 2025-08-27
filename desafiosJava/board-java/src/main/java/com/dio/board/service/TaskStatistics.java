package com.dio.board.service;

public class TaskStatistics {
    private long totalTasks;
    private long todoTasks;
    private long inProgressTasks;
    private long reviewTasks;
    private long doneTasks;
    private long overdueTasks;
    private double completionRate;
    
    // Construtores
    public TaskStatistics() {}
    
    public TaskStatistics(long totalTasks, long todoTasks, long inProgressTasks, long reviewTasks, 
                         long doneTasks, long overdueTasks, double completionRate) {
        this.totalTasks = totalTasks;
        this.todoTasks = todoTasks;
        this.inProgressTasks = inProgressTasks;
        this.reviewTasks = reviewTasks;
        this.doneTasks = doneTasks;
        this.overdueTasks = overdueTasks;
        this.completionRate = completionRate;
    }
    
    // Getters e Setters
    public long getTotalTasks() {
        return totalTasks;
    }
    
    public void setTotalTasks(long totalTasks) {
        this.totalTasks = totalTasks;
    }
    
    public long getTodoTasks() {
        return todoTasks;
    }
    
    public void setTodoTasks(long todoTasks) {
        this.todoTasks = todoTasks;
    }
    
    public long getInProgressTasks() {
        return inProgressTasks;
    }
    
    public void setInProgressTasks(long inProgressTasks) {
        this.inProgressTasks = inProgressTasks;
    }
    
    public long getReviewTasks() {
        return reviewTasks;
    }
    
    public void setReviewTasks(long reviewTasks) {
        this.reviewTasks = reviewTasks;
    }
    
    public long getDoneTasks() {
        return doneTasks;
    }
    
    public void setDoneTasks(long doneTasks) {
        this.doneTasks = doneTasks;
    }
    
    public long getOverdueTasks() {
        return overdueTasks;
    }
    
    public void setOverdueTasks(long overdueTasks) {
        this.overdueTasks = overdueTasks;
    }
    
    public double getCompletionRate() {
        return completionRate;
    }
    
    public void setCompletionRate(double completionRate) {
        this.completionRate = completionRate;
    }
}
