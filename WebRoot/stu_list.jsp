<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login_suc.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <s:debug/>
  <script>
  function confirmDel(){
  	return confirm("确定删除？");
  }
  </script>
<table border="1">
  <tr><td>id<td>name<td>class<td>age<td>java<td>删除
    <s:iterator value="stus" var="row1">
    <tr>
      <td><s:property value="#row1[0]"/>
      <td><s:property value="#row1[1]"/>
      <td><s:property value="#row1[2]"/>
      <td><s:property value="#row1[3]"/>
      <td><s:property value="#row1[4]"/>
    <td>
      <s:url var="delUrl" action="studel">
         <s:param name="stu.stuId" value="#row1[0]"/>
      </s:url>
      <a href="${delUrl}" onClick="return confirmDel();">删除</a>
    </s:iterator>
    </table>
  </body>
</html>
