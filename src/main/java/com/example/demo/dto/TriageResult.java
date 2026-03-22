package com.example.demo.dto;

public class TriageResult {
	private String level;
    private String message;
    private String action;

    public TriageResult(String level, String message, String action) {
        this.level = level;
        this.message = message;
        this.action = action;
    }

    public String getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }

    public String getAction() {
        return action;
    }

}
