package controller;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class Upload extends ActionSupport {
	private File[] files;
	private String[] filesContentType;
	private String[] filesFileName;
	public File[] getFiles() {
		return files;
	}
	public void setFiles(File[] files) {
		this.files = files;
	}
	public String[] getFilesContentType() {
		return filesContentType;
	}
	public void setFilesContentType(String[] filesContentType) {
		this.filesContentType = filesContentType;
	}
	public String[] getFilesFileName() {
		return filesFileName;
	}
	public void setFilesFileName(String[] filesFileName) {
		this.filesFileName = filesFileName;
	}
	public String execute() throws IOException {
		
		String realPath=ServletActionContext.getServletContext().getRealPath("/myFile");
        IOUtils.copyFile(files, filesFileName, realPath);
		return SUCCESS;
		
	}

}
