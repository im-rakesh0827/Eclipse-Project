<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>
</head>
<body>
<%@ page import="java.sql.*" %>
<%@ page import ="javax.swing.*" %>
<%
String fName = request.getParameter("fullName");
String emailId = request.getParameter("email");
String phoneNum = request.getParameter("phone");
String gen = request.getParameter("gender");
String msg = request.getParameter("message");
try{
	ResultSet rs = null;
	Connection con = null;
	PreparedStatement ps = null;
	String query = "insert into contact(name, email, phone, gender, message)"+"values(?, ?, ?, ?, ?)";
	final String DBURL = "jdbc:mysql://localhost:3306/onlinevoting";
	final String USERNAME = "root";
	final String PASSWORD = "Apple@0827";
	final String driver = "com.mysql.cj.jdbc.Driver";
	Class.forName(driver);
	con = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
	ps = con.prepareStatement(query);
	ps.setString(1, fName);
	ps.setString(2, emailId);
	ps.setString(3, phoneNum);
	ps.setString(4, gen);
	ps.setString(5, msg);
	int rowData = ps.executeUpdate();
	if(rowData>0){
		out.print("<h1>Your Feedback/Message Is Successfully Updated : <h1>");
	}else{
		out.print("<h1>Error Message<h1>");
	}
}catch(Exception e){
	out.print(e);
}

%>

</body>
</html>