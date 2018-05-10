package controller;

import java.io.InputStream;

import javax.mail.internet.ContentType;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class downLoad extends ActionSupport {

	private  String downPath;
	private  String contentType;
	private  String filename;
	public String getDownPath() {
		return downPath;
	}
	public void setDownPath(String downPath) {
		this.downPath = downPath;
	}
	public String getContenTypeString() {
		return contentType;
	}
	public void setContenTypeString(String contentType) {
		this.contentType = contentType;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public InputStream getInputStream(){
		return ServletActionContext.getServletContext().getResourceAsStream(downPath);
		
		
	}
	public String execute(){
		
		filename=downPath;
		downPath="myFile/"+downPath;
		contentType="application/x-masdownload";
		return SUCCESS;
	}
}
