package com.luv2code.pmo.util;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

@Component(value = "local")
public class LocalFileManager implements FileManager {

    @Override
    public File readFile(String fileName) {

        URL url = this.getClass()
                .getClassLoader()
                .getResource("data/"+fileName);

        if (url == null) {
            throw new IllegalArgumentException(fileName + " is not found 1");
        }
        File outputFile = new File(url.getFile());
        return outputFile;
    }
}
