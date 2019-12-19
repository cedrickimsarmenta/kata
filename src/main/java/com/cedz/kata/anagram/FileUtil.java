package com.cedz.kata.anagram;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
	
	public static FileUtil _INSTANCE;
	
	public static FileUtil getInstance() {
		if(_INSTANCE == null) {
			_INSTANCE = new FileUtil();
		}
		return _INSTANCE;
	}
	
	private FileUtil() {
		
	}
	public File getFileFromResources(String fileName) {

        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }

    }

	public List<String> readFile(File file) throws IOException {

        if (file == null) return null;

        List<String> content = new ArrayList<String>();
        try (FileReader reader = new FileReader(file);
             BufferedReader br = new BufferedReader(reader)) {

            String line;
            while ((line = br.readLine()) != null) {
            	content.add(line.toLowerCase());
            }
        }
        
        return content;
    }
}
