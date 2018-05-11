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
		String sql="select * from student";
		List<String[]> stus =new ArrayList<>();
		try(Connection con =DriverManager.getConnection(url, user, pass);
				PreparedStatement prst =con.prepareStatement(sql);){
			try(ResultSet rs = prst.executeQuery();){
				while(rs.next()){
					String[] row=new String[5];
					row[0]=rs.getString(1);
					row[1]=rs.getString(2);
					row[2]=rs.getString(3);
					row[3]=rs.getString(4);
					row[4]=rs.getString(5);
					stus.add(row);
				}
				
			}
			
		}
					return stus;
	}

	@Override
	public Stu findById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delById(long id) throws Exception {
		Class.forName(driver);
		String sql="delete from student where id=?";
		boolean isSuc=false;
		try{
			Connection con = DriverManager.getConnection(url, user, pass);
			PreparedStatement prst = con.prepareStatement(sql);
			prst.setLong(1, id);
			int row= prst.executeUpdate();
			isSuc=row>0;
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return isSuc;
	}

	@Override
	public boolean update(Stu stu) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(Stu stu) throws Exception {
		Class.forName(driver);
		boolean isSuc;
		String sql="insert into student(sname,sdept,sage,java) values(?,?,?,?)";
		List<String[]> stus =new ArrayList<>();
		try(Connection con =DriverManager.getConnection(url, user, pass);
				PreparedStatement prst =con.prepareStatement(sql);){
				prst.setString(1, stu.getSname());
				prst.setString(2, stu.getSdept());
				prst.setInt(3, stu.getAge());
				prst.setInt(4, stu.getJava());
				int row =prst.executeUpdate();
				isSuc=row>0;
			}
		return isSuc;
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
