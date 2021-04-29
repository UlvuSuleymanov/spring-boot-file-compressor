package com.task.compressor.service;

import com.task.compressor.constants.FileStatus;
import com.task.compressor.model.ReadyTaskResponse;
import com.task.compressor.model.Task;
import org.springframework.stereotype.Service;
import org.zeroturnaround.zip.ZipUtil;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
public class FileServiceImpl implements FileService {


    @Override
    public String getNewFilePath(String oldPath) {

        if(oldPath.toCharArray()[oldPath.length()-1]=='/')
            oldPath.substring(0,oldPath.length()-2);


      String[] crumbs = oldPath.split("/");
      String fileName =  "/"+crumbs[crumbs.length-1];

      if(fileName.contains("."))
      {
         return oldPath.replace(fileName,"")+"FILE-"+ UUID.randomUUID().toString()+".zip";

      }




      return oldPath.replace(fileName,"")+"FOLDER-"+ UUID.randomUUID().toString()+".zip";

     }




    @Override
    public ReadyTaskResponse zip(String importedFilePath) {

        try {

            String exportedFilePath = getNewFilePath(importedFilePath);
            File source = new File(importedFilePath);
            File export = new File(exportedFilePath);



            if (source.isDirectory())
                ZipUtil.pack(source, export);

            else if (source.isFile())
                ZipUtil.packEntry(source, export);

            Thread.sleep(7000);

            return  new ReadyTaskResponse(FileStatus.COMPLETED.getStatus(),exportedFilePath);

        } catch (Exception ex) {

            return  new ReadyTaskResponse(FileStatus.FAILED.getStatus(),null);

        }


    }


}














