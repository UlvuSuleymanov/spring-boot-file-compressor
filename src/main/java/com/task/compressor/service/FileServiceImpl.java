package com.task.compressor.service;

import com.task.compressor.constants.TaskStatus;
 import com.task.compressor.model.ReadyTaskResponse;
import org.springframework.stereotype.Service;
import java.io.*;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public ReadyTaskResponse zipFile(String importedFilePath) {

        File source = new File(importedFilePath);

        if(!source.exists()) {
            System.out.println("a");

            return new ReadyTaskResponse(TaskStatus.FAILED.getStatus(), null);
        }

        String expoPath=source.getParent()+"\\"+UUID.randomUUID()+".zip";

        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream( new FileOutputStream(expoPath));

            zip(source,zipOutputStream,source.getName());
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            zipOutputStream.flush();

            return  new ReadyTaskResponse(TaskStatus.COMPLETED.getStatus(),expoPath.replace("\\", "/"));
        }catch(Exception e) {
            e.printStackTrace();

            return  new ReadyTaskResponse(TaskStatus.FAILED.getStatus(),null);
        }
       


    }

    @Override
    public void zip(File source, ZipOutputStream zipOutputStream,String fileName) throws IOException {

        if (source.isDirectory()) {
            if (fileName.endsWith("/")) {
                zipOutputStream.putNextEntry(new ZipEntry(fileName));
                zipOutputStream.closeEntry();
            } else {
                zipOutputStream.putNextEntry(new ZipEntry(fileName + "\\"));
                zipOutputStream.closeEntry();
            }
            File[] children = source.listFiles();
            for (File child : children) {
                zip(child, zipOutputStream, fileName + "\\" + child.getName());
            }
            return;
        }

        FileInputStream fis = new FileInputStream(source);
        ZipEntry zipEntry = new ZipEntry(fileName);
        zipOutputStream.putNextEntry(zipEntry);

        byte[] bytes = new byte[1024];
        int length;
        while ((length = fis.read(bytes)) >= 0) {
            zipOutputStream.write(bytes, 0, length);
        }
        fis.close();

    }


}














