package com.task.compressor.model;

public class ZipFileModel {

    private Integer id;
    private String status;
    private String path;


    public ZipFileModel() {

    }

    public ZipFileModel(Integer id, String status, String path) {
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
}
