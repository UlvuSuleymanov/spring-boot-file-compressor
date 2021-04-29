package com.task.compressor.model;

public class Task {

    private Integer id;
    private String status;
    private String path;

    private String exportPath;


    public Task() {

    }

    public Task(Integer id, String status, String path) {
        this.id = id;
        this.status = status;
        this.path = path;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getExportPath() {
        return exportPath;
    }

    public void setExportPath(String exportPath) {
        this.exportPath = exportPath;
    }
}
