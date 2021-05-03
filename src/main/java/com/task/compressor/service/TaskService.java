package com.task.compressor.service;

import com.task.compressor.constants.TaskStatus;
import com.task.compressor.model.ReadyTaskResponse;
import com.task.compressor.model.Task;

import java.io.IOException;

public interface TaskService {

    Task executeTask(String path) throws IOException, InterruptedException;

    ReadyTaskResponse getStatus(Integer id);

}
