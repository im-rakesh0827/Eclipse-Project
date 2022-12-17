<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Loging Page</title>
</head>
<body>
	<div>
	<h1 align=center style="color:blue">User Login</h1>
	</div>
	<form action=LoginServlet method=post>
		<table align=center>
			<tr><td>Enter Name</td><td><input type=text name=txtName></td></tr> <br>
			<tr><td>Enter Password</td><td><input type=password name=txtPwd></td></tr><br>
			<tr><td><input type="submit" value="Login"></td><td><input type=reset></td></tr>
		</table>
	</form>

</body>
</html>