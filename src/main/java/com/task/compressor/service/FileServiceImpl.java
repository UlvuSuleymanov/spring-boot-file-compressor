package com.task.compressor.service;

import com.task.compressor.constants.FileStatus;
import com.task.compressor.model.Task;
import org.springframework.stereotype.Service;

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
    public boolean checkFileExistence(String path) {
        File f = new File(path);

        return f.exists();

    }

    @Override
    public String getNewFilePath(String oldPath) {
     String[] crumbs = oldPath.split("/");
      String fileName =  crumbs[crumbs.length-1];
        String path = oldPath.replace(fileName,"")+ UUID.randomUUID().toString()+".zip";
        System.out.println(path);
      return path;
     }




    @Override
    public String zipFile( String importedFilePath, String exportedFilePath) {

        try{
        FileOutputStream fos = new FileOutputStream(exportedFilePath);
        ZipOutputStream zipOS = new ZipOutputStream(fos);


            writeToZipFile(importedFilePath, zipOS);

            zipOS.finish();
            zipOS.close();
            zipOS.flush();

            fos.close();

            //for showing IN_PROGRESS status
            Thread.sleep(7000);

           return FileStatus.COMPLETED.getStatus();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();

        }

        return FileStatus.FAILED.getStatus();
    }



    void writeToZipFile(String path, ZipOutputStream zipStream) throws FileNotFoundException, IOException {

        File aFile = new File(path);

        FileInputStream fis = new FileInputStream(aFile);

        ZipEntry zipEntry = new ZipEntry(path);
        zipStream.putNextEntry(zipEntry);
        byte[] bytes = new byte[1024];
        int length;

        while ((length = fis.read(bytes)) >= 0)
        {
            zipStream.write(bytes, 0, length);
        }

        zipStream.finish();
        zipStream.flush();
        zipStream.closeEntry();

        fis.close();


    }











}
