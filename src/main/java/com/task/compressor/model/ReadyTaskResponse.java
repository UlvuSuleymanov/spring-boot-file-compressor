package com.task.compressor.model;

public class ReadyTaskResponse {

    private String status;
    private String path;


    public ReadyTaskResponse() {

    }


    public ReadyTaskResponse(String status, String path) {
        this.status = status;
        this.path = path;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


}
