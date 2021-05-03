package com.task.compressor.exception;

 import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

 import java.io.FileNotFoundException;

@RestControllerAdvice
public class TaskExceptionHandler {

    @ExceptionHandler({TaskNotFoundException.class})
    public String taskNoFound() {
        return "There is no task with this id.";
    }

    @ExceptionHandler({FileNotFoundException.class})
    public String fileNotFound() {
        return "File not found. Please enter a valid file or folder path. \ninfo: names on the path must be separated by '/' ";
    }

}
