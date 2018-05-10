package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.List;

import com.opensymphony.xwork2.Result;

import domain.Stu;

public class stuDaoImp implements StuDao {
	String url = "jdbc:hsqldb:hsql://localhost";
	String driver = "org.hsqldb.jdbcDriver";
	String user = "sa";
	String pass = "";
	@Override
	public List<String[]> getAllStus() throws Exception {
		Class.forName(driver);
		String sql="select * from stu";
		List<String[]> stus =new ArrayList<>();
		try(Connection con =DriverManager.getConnection(url, user, pass);
				PreparedStatement prst =con.prepareStatement(sql);){
			
			
		}
		return stus;
	}

	@Override
	public Stu findById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delById(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Stu stu) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean save(Stu stu) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkstu(String username) throws Exception {
		Class.forName(driver);
		String sql="select * from student where sname=?";
		boolean isHave=false;
		try{
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement prst = con.prepareStatement(sql);
			prst.setString(1, username);
			ResultSet rs= prst.executeQuery();
			isHave =rs.next();
		}catch(Exception e){
			e.printStackTrace();
		}
		return isHave;
	}

}
