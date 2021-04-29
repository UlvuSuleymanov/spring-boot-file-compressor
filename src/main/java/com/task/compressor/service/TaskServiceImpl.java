package com.task.compressor.service;

import com.task.compressor.constants.FileStatus;
import com.task.compressor.model.ReadyTaskResponse;
import com.task.compressor.model.Task;
import com.task.compressor.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private FileService fileService;

    @Override
    public Task zipFile(String path) {

         Task task = new Task();
         task.setPath(path);
         task.setStatus(FileStatus.IN_PROGRESS.getStatus());

         task = TaskRepository.save(task);


        ReadyTaskResponse readyTaskResponse=fileService.zip(task.getPath());

        task.setStatus(readyTaskResponse.getStatus());
        task.setExportPath(readyTaskResponse.getPath());

        TaskRepository.update(task);




        return task;
    }

    @Override
    public ReadyTaskResponse getStatus(Integer id) {

        Task task = TaskRepository.getTask(id);
        return  new ReadyTaskResponse(task);
    }


}
