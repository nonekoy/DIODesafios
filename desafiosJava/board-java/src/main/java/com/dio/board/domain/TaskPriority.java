package com.dio.board.domain;

public enum TaskPriority {
    LOW("Baixa"),
    MEDIUM("Média"),
    HIGH("Alta"),
    URGENT("Urgente");
    
    private final String displayName;
    
    TaskPriority(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
}
