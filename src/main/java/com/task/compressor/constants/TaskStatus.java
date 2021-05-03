package com.task.compressor.constants;

public enum TaskStatus {
    IN_PROGRESS("IN_PROGRESS"),
    FAILED ("FAILED"),
    COMPLETED("COMPLETED");



    private final String status;

    TaskStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
