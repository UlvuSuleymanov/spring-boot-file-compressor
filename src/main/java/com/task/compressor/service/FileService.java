package com.task.compressor.service;

import com.task.compressor.constants.FileStatus;
import com.task.compressor.model.Task;

import java.io.File;

public interface FileService {


    boolean checkFileExistence(String path);

    //return status
    public String zipFile(String importedFilePath, String exportedFilePath);


    //return path with random name from same folder
    String getNewFilePath(String oldPath);





}
