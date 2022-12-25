package com.adpushup.takeHomeTest.utils;

import org.springframework.stereotype.Component;

import java.io.File;


public class DirectoryValidator {

    public static File validateDirectory(String path){
        if(path != null){
            File directory = new File(path);
            if (directory.exists() && directory.isDirectory()) {
                return directory;
            }
        }
        return null;
    }

}
