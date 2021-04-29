package com.task.compressor.repository;

import com.task.compressor.constants.FileStatus;
import com.task.compressor.model.ZipFileModel;

import java.util.ArrayList;
import java.util.List;

public class FileRepository {

    private  static List<ZipFileModel> zippedFiles = new ArrayList<>();

    //I assume that no object will be deleted from the list.
    public static  ZipFileModel save(String path){
        ZipFileModel zippedFile = new ZipFileModel(

            zippedFiles.size()+1,
                FileStatus.IN_PROGRESS.getStatus(),
                path
        );


       zippedFiles.add(zippedFile);

       return zippedFile;
    }



    public static void setStatus(String status,Integer id){
        zippedFiles.get(id).setStatus(status);
    }

    public static void getStatus(Integer id){
        zippedFiles.get(id).getStatus();
    }
}
