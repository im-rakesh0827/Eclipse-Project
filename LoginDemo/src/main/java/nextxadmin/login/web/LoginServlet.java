package nextxadmin.login.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nextxadmin.login.bean.LoginBean;
import nextxadmin.login.database.LoginDao;

import java.io.IOException;
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		
		LoginBean loginBean = new LoginBean();
		
		loginBean.setName(name);
		loginBean.setPassword(password);
		
		LoginDao loginDao = new LoginDao();
		if(loginDao.validate(loginBean))response.sendRedirect("loginSuccess.jsp");
		else response.sendRedirect("login.jsp");
		
	}

}
