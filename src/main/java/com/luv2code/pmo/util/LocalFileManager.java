package com.luv2code.pmo.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.net.URL;

import org.springframework.stereotype.Component;

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

	@Override
	public ByteArrayInputStream readBaos(String fileName) {
		// TODO Auto-generated method stub
		return null;
	}
}
