package com.dio.board.domain;

public enum TaskStatus {
    TODO("A Fazer"),
    IN_PROGRESS("Em Andamento"),
    REVIEW("Em Revisão"),
    DONE("Concluída");
    
    private final String displayName;
    
    TaskStatus(String displayName) {
        this.displayName = displayName;
    }
    
    public String getDisplayName() {
        return displayName;
    }
}
