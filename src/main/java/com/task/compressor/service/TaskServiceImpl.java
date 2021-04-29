package com.task.compressor.service;

import com.task.compressor.constants.FileStatus;
import com.task.compressor.model.ReadyTaskResponse;
import com.task.compressor.model.Task;
import com.task.compressor.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private FileService fileService;

    @Override
    public Task zipFile(String path) {

         Task task = new Task();
         task.setPath(path);
         task.setStatus(FileStatus.FAILED.getStatus());
         task = TaskRepository.save(task);

        if(!fileService.checkFileExistence(path))
            return task;

        task.setStatus(FileStatus.IN_PROGRESS.getStatus());

        TaskRepository.update(task);

        String newPath = fileService.getNewFilePath(path);
        String status=fileService.zipFile(task.getPath(),newPath);

        task.setStatus(status);
        task.setExportPath(newPath);

        return task;
    }

    @Override
    public ReadyTaskResponse getStatus(Integer id) {

        ReadyTaskResponse readyTaskResponse = new ReadyTaskResponse();
        Optional<Task> taskOptional = Optional.ofNullable(TaskRepository.getTask(id));


        if(taskOptional.isPresent()){
            Task task = taskOptional.get();

            readyTaskResponse.setStatus(task.getStatus());

            if(!taskOptional.get().getStatus().equals(FileStatus.COMPLETED.getStatus()))
              return readyTaskResponse ;


            readyTaskResponse.setPath(task.getExportPath());
            return readyTaskResponse;
        }



        return readyTaskResponse;
    }


}
