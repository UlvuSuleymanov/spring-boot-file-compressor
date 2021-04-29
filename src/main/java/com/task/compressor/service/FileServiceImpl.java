package com.task.compressor.service;

import com.task.compressor.repository.FileRepository;
import org.springframework.stereotype.Service;

import java.io.File;
@Service
public class FileServiceImpl implements FileService {

    @Override
    public String zipFile(String path) {
        return null;
    }

    @Override
    public String getStatus(Integer id) {

        return "ok";
    }

    @Override
    public boolean checkFileExistence(String path) {
        File f = new File(path);

        return f.exists();

    }

}
