package com.task.compressor.constants;

public enum FileStatus {
    IN_PROGRESS("IN_PROGRESS"),
    FAILED ("FAILED"),
    COMPLETED("COMPLETED");



    private final String status;

    FileStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
