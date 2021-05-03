package com.task.compressor.service;

import com.task.compressor.model.ReadyTaskResponse;

import java.io.File;
import java.io.IOException;
import java.util.zip.ZipOutputStream;

public interface FileService {

    ReadyTaskResponse zipFile(String importedFilePath) throws IOException;

    void zip(File source, ZipOutputStream zipOutputStream, String fileName) throws IOException;


}
