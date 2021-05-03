package com.task.compressor.service;

import com.task.compressor.constants.TaskStatus;
import com.task.compressor.model.Task;
import com.task.compressor.repository.TaskRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

 import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {
    @InjectMocks
    private TaskServiceImpl taskService;

    @Mock
    private FileServiceImpl fileService;


    @Test
    void executeTask() {
        Task task = new Task();
        //I set not valid path
        task.setPath(UUID.randomUUID().toString());
        task.setStatus(TaskStatus.IN_PROGRESS.getStatus());
        Task savedTask= TaskRepository.save(task);

        Assertions.assertEquals(savedTask.getId(),0);
        Assertions.assertEquals(task.getStatus(),TaskStatus.IN_PROGRESS.getStatus());



    }

    @Test
    void getStatus() {



    }
}