package dao;

import java.util.*;

import domain.Stu;
public interface  StuDao {
	List<String[]> getAllStus() throws Exception;
	Stu findById()throws Exception;
	boolean checkstu(String username)throws Exception;
	boolean delById(long id)throws Exception;
	boolean update(Stu stu)throws Exception;
	boolean add(Stu stu)throws Exception;
	
}
