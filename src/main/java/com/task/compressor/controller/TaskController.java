package com.task.compressor.controller;

import com.task.compressor.model.ZipRequestModel;
import com.task.compressor.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {

    @Autowired
    private FileService fileService;

    @PostMapping("/zip")
    public String zip(@RequestBody final ZipRequestModel zipRequestModel){


     return "ok";
    }

    @GetMapping(value = "/status")
    String checkFileStatus(@RequestParam String path){

    return "ok";
    }

}
