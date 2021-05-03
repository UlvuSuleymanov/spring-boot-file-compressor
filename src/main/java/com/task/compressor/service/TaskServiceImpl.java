package com.task.compressor.service;

import com.task.compressor.constants.TaskStatus;
import com.task.compressor.model.ReadyTaskResponse;
import com.task.compressor.model.Task;
import com.task.compressor.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private FileService fileService;

    @Override
    public Task executeTask(String path) throws IOException, InterruptedException {



        Task task = new Task();
        task.setPath(path);
        task.setStatus(TaskStatus.IN_PROGRESS.getStatus());
        task = TaskRepository.save(task);
        Thread.sleep(7000);

        try {
            ReadyTaskResponse readyTaskResponse = fileService.zipFile(task.getPath());
            task.setStatus(readyTaskResponse.getStatus());
            task.setExportPath(readyTaskResponse.getPath().replace("\\", "/"));

         }catch (Exception e){
            task.setStatus(TaskStatus.FAILED.getStatus());
        }
        TaskRepository.update(task);


        return task;
    }


    @Override
    public ReadyTaskResponse getStatus(Integer id) {
        Task task = TaskRepository.getTask(id);
        return  new ReadyTaskResponse(task);
    }


}
