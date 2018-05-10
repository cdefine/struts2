package controller;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

public class IOUtils {
	public static void copyFile(File[] files,String[] filesFileName,String realPath) throws IOException{
		
		File file= new File(realPath);
		if(!file.exists()){
			file.mkdirs();
		}
		for(int i=0;i<files.length;i++){
			File upFile=files[i];
			FileUtils.copyFile(upFile, new File(file,filesFileName[i]));
		}
	}
}
