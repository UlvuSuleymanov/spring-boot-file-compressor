package com.task.compressor.service;

import com.task.compressor.constants.FileStatus;
import com.task.compressor.model.ReadyTaskResponse;
import com.task.compressor.model.Task;

import java.io.File;

public interface FileService {




    ReadyTaskResponse zip(String importedFilePath);


    //return path with random name from same folder
    String getNewFilePath(String oldPath);





}
