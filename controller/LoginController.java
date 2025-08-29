package com.aurionpro.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.model.User;
import com.aurionpro.service.UserService;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = null;

    public LoginController() {
        super();
        userService = new UserService();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("usernameTxt");
		String password = request.getParameter("passwordTxt");
		User user = new User(username,password);
		user = userService.checkUser(user);
		if(user==null)
		{
			response.sendRedirect("LoginError.jsp");
			return;
		}
		
		request.getSession().setAttribute("userId", user.getUserId());
		request.getSession().setAttribute("user", user);
		
		RequestDispatcher dispatcher = null;
		if(user.isAdmin())
		{
			request.getSession().setAttribute("accountId", user.getUserId());
			dispatcher = request.getRequestDispatcher("AdminDashboard.jsp");
			dispatcher.forward(request, response);
		}
		dispatcher = request.getRequestDispatcher("CustomerAccountsController");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
