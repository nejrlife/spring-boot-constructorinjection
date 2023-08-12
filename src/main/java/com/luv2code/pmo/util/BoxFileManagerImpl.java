package com.luv2code.pmo.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import org.springframework.stereotype.Component;

import com.box.sdk.BoxAPIConnection;
import com.box.sdk.BoxFile;
import com.box.sdk.BoxFolder;
import com.box.sdk.BoxItem;

@Component(value = "box")
public class BoxFileManagerImpl implements FileManager {

    public File downloadFile() {
        return null;
    }

    public void uploadFile(File file) {

    }

    @Override
    public File readFile(String fileName) {
        InputStream input = this.readBaos(fileName);
        File file = new File(fileName);
        try (OutputStream output = new FileOutputStream(file)) {
            input.transferTo(output);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return file;
    }

    @Override
    public ByteArrayInputStream readBaos(String fileName) {

        BoxAPIConnection api = new BoxAPIConnection("frHLAaMaJHyWJLOj1KS5kr2SnJcdo8sR");
        BoxFolder rootFolder = BoxFolder.getRootFolder(api);
        BoxFolder sowsFolder = getBoxFolderFromFolder(api, rootFolder, "SOWS-Files");
        BoxFile file = getBoxFileFromFolder(api, sowsFolder, fileName);

        ByteArrayOutputStream stream = null;
        try {
            stream = new ByteArrayOutputStream();
            file.download(stream);
            stream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ByteArrayInputStream inStream = null;
        if (stream != null) {
            inStream = new ByteArrayInputStream(stream.toByteArray());
        }
        // TODO Auto-generated method stub
        return inStream;
    }

    private BoxFile getBoxFileFromFolder(BoxAPIConnection api, BoxFolder folder, String fileName) {
        Iterator<BoxItem.Info> it = folder.getChildren().iterator();
        BoxFile file = null;
        while (it.hasNext()) {
            BoxItem.Info i = it.next();
            if (i.getName().equals(fileName)) {
                file = new BoxFile(api, i.getID());
                break;
            }
        }
        return file;
    }

    private BoxFolder getBoxFolderFromFolder(BoxAPIConnection api, BoxFolder folder, String folderName) {
        Iterator<BoxItem.Info> it = folder.getChildren().iterator();
        BoxFolder sowsFolder = null;
        while (it.hasNext()) {
            BoxItem.Info i = it.next();
            if (i.getName().equals(folderName)) {
                sowsFolder = new BoxFolder(api, i.getID());

                break;
            }
        }
        return sowsFolder;
    }
}
