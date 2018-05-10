package controller;

import com.opensymphony.xwork2.ActionSupport;

import dao.StuDao;
import dao.stuDaoImp;

public class checkLogin extends ActionSupport{
	 private  String  username;
	 private  String pass;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String execute(){	
		return SUCCESS;
			
	}
	public String check() throws Exception{
		StuDao stu =new stuDaoImp();
		if(stu.checkstu(username))
			return "suc";
		else 
			return "fail";
		
	}
	 
}
