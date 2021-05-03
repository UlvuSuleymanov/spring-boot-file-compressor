package com.task.compressor.repository;

import com.task.compressor.exception.TaskNotFoundException;
import com.task.compressor.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    //I assume that no object will be deleted from the list.
    private  static List<Task> tasks = new ArrayList<>();

    public static Task save(Task task){
       task.setId(tasks.size());
       tasks.add(task);
       return task;
    }
    public  static Task update (Task task){

        tasks.set(task.getId(),task);
        return tasks.get(task.getId());
    }




    public static void setStatus(String status,Integer id){
        tasks.get(id).setStatus(status);
    }


    public static Task getTask(Integer id){
        int size = tasks.size();
        if(size==0 | id>=tasks.size()) {
            throw new TaskNotFoundException();
        }
        return tasks.get(id);

    }

}
