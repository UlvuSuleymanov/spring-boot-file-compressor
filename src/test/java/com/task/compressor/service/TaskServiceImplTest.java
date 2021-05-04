package com.task.compressor.service;

import com.task.compressor.constants.TaskStatus;
import com.task.compressor.exception.TaskNotFoundException;
import com.task.compressor.model.Task;
import com.task.compressor.repository.TaskRepository;
 import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

 import java.io.IOException;
import java.util.UUID;

 class TaskServiceImplTest {

    private FileService fileService;

     @BeforeEach
     void initUseCase() {
         fileService = new FileServiceImpl();
     }


    @Test
    void executeTask() throws IOException {
        Task task = new Task();
        //I set   invalid path
        task.setPath(UUID.randomUUID().toString());
        task.setStatus(TaskStatus.IN_PROGRESS.getStatus());
        Task savedTask= TaskRepository.save(task);

        Assertions.assertEquals(savedTask.getId(),0);

        Assertions.assertEquals(savedTask.getStatus(),TaskStatus.IN_PROGRESS.getStatus());
        Assertions.assertEquals(fileService.zipFile(task.getPath()).getStatus(),TaskStatus.FAILED.getStatus());


    }

    @Test
    void getStatus() {
        Task task = new Task();

         Task savedTask= TaskRepository.save(task);

        Assertions.assertThrows(TaskNotFoundException.class,()->TaskRepository.getTask(task.getId()+1));



    }
}