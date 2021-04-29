package com.task.compressor.repository;

import com.task.compressor.constants.FileStatus;
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
        if(id<tasks.size()) {
             return tasks.get(id);
        }
        return null;
    }

}
