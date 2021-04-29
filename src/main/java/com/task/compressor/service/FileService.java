package com.task.compressor.service;

public interface FileService {
    String zipFile(String path);

    String getStatus(Integer id);

    boolean checkFileExistence(String path);

}
