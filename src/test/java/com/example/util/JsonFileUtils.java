package com.example.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class JsonFileUtils {
    
    public String getJsonFromFile(String fileName) throws IOException {

        String pathValue = getClass().getClassLoader().getResource(fileName).getPath();
        Path path = Path.of(pathValue);

        return Files.readString(path);
    }
}
