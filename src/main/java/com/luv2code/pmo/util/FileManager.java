package com.luv2code.pmo.util;

import java.io.ByteArrayInputStream;
import java.io.File;

public interface FileManager {
    File readFile(String fileName);
    
    ByteArrayInputStream readBaos(String fileName);
}
