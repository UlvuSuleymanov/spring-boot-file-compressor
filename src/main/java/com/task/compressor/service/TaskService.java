package com.task.compressor.service;

import com.task.compressor.model.ReadyTaskResponse;
import com.task.compressor.model.Task;

public interface TaskService {

    Task zipFile(String path);

    ReadyTaskResponse getStatus(Integer id);

}
