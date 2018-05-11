package controller;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.StuDao;
import dao.stuDaoImp;
import domain.Stu;

public class StuInfoAction extends ActionSupport {
	List<String[]> stus ;
	Stu stu;
	public List<String[]> getStus() {
		return stus;
	}

	public void setStus(List<String[]> stus) {
		this.stus = stus;
	}


	public Stu getStu() {
		return stu;
	}

	public void setStu(Stu stu) {
		this.stu = stu;
	}
	public String add() throws Exception{
		StuDao dao=new stuDaoImp();
		boolean isSuc=dao.add(stu);
		return isSuc?SUCCESS:ERROR;
	}
	public String del()throws Exception{
		StuDao dao=new stuDaoImp();
		boolean isSuc=dao.delById(stu.getStuId());
		return isSuc?SUCCESS:ERROR;		
	}
	public String execute() throws Exception{
		stuDaoImp dao=new stuDaoImp();
		stus=dao.getAllStus();
		return SUCCESS;
				
	}
	
}
