package com.luv2code.pmo.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
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
        return null;
    }

	@Override
	public ByteArrayInputStream readBaos(String fileName) {
		
		BoxAPIConnection api = new BoxAPIConnection("wxNnQmEUuQrDVhSbPwePDKeG9Hx9YiTa");
    	BoxFolder rootFolder = BoxFolder.getRootFolder(api);
		BoxFolder sowsFolder = getBoxFolderFromFolder(api, rootFolder, "SOWS-Files");
		BoxFile file = getBoxFileFromFolder(api, sowsFolder, fileName);
   
    	BoxFile.Info info = file.getInfo();
    	
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
		while(it.hasNext()) {
    		BoxItem.Info i = it.next();
    		if(i.getName().equals(fileName)){
	    	    file = new BoxFile(api, i.getID());
	    	    break;
    		}
		}
		return file;
	}
	
	private BoxFolder getBoxFolderFromFolder(BoxAPIConnection api, BoxFolder folder, String folderName) {
		Iterator<BoxItem.Info> it = folder.getChildren().iterator();
		BoxFolder sowsFolder = null;
		while(it.hasNext()) {
    		BoxItem.Info i = it.next();
    		if(i.getName().equals(folderName)){
	    	    sowsFolder = new BoxFolder(api, i.getID());
	    	    
	    	    break;
    		}
		}
		return sowsFolder;
	}
}
