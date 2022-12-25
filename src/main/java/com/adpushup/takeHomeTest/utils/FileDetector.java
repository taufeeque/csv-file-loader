package com.adpushup.takeHomeTest.utils;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileFilter;

@Component
public class FileDetector {
    private  File directory;
    private static final String CSV =".csv";

    private static FileFilter fileFilter = new FileFilter() {
        public boolean accept(File file) {
            return file.getName().endsWith(CSV);
        }
    };

    public static File[] getAllCsvDirectory(File directory){
       if(null != directory && directory.isDirectory() && directory.canRead()){
        File[] files  = directory.listFiles(fileFilter);
        return  files;
       }
       return null;
    }




}
