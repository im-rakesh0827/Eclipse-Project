package com.xadmin.usermanagement.web;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.xadmin.usermanagement.bean.UserBean;
import com.xadmin.usermanagement.dao.UserDao;
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;
	public void init() throws ServletException {
		userDao = new UserDao();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action  = request.getServletPath();
		switch(action) {
		case "/new" : 
			showNewForm(request, response);
			break;
		case "/insert" : 
			try {
				insertUser(request, response);
			} catch (ServletException | IOException | SQLException e4) {
				e4.printStackTrace();
			}
			break;
		case "/delete" : 
			try {
				deleteUser(request, response);
			} catch (ServletException | IOException | SQLException e3) {
				e3.printStackTrace();
			}
			break;
		case "/edit" : 
			try {
				showEditForm(request, response);
			} catch (ServletException | IOException | SQLException e2) {
				e2.printStackTrace();
			}
			break;
		case "/update" : 
			try {
				updateUser(request, response);
			} catch (ServletException | IOException | SQLException e1) {
				e1.printStackTrace();
			}
			break;
		default:
			try {
				listUser(request, response);
			} catch (ServletException | IOException | SQLException e) {
				e.printStackTrace();
			}
			break;
		}
		
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}

	
	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		UserBean newUser  = new UserBean(name, email, country);
		userDao.insertUser(newUser);
		response.sendRedirect("list");
	}
	
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		userDao.deleteUser(id);
		response.sendRedirect("list");
	}
	
	private void showEditForm (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		
		int id = Integer.parseInt(request.getParameter("id"));
		UserBean existingUser;
		try {
			existingUser = userDao.selectUser(id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
			request.setAttribute("user", existingUser);
			dispatcher.forward(request, response);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	private void updateUser (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		
		UserBean user = new UserBean(id, name, email, country);
		userDao.updateUser(user);
		response.sendRedirect("list");	
	}
	
	//								Default Case : 
	private void listUser (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		try {
			List<UserBean> listUser = userDao.selectAllUser();
			request.setAttribute("listUser", listUser);
			RequestDispatcher dispatcher = request.getRequestDispatcher("user-from.jsp");
			dispatcher.forward(request, response);
			
		}catch(Exception e) {
			 
			e.printStackTrace();
		}
		
	}
		
	
	
	
	
	
	

}
