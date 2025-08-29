package com.aurionpro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.model.User;
import com.aurionpro.service.UserService;


@WebServlet("/GetAllUsersController")
public class GetAllUsersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService = null;

    public GetAllUsersController() {
        super();
        userService = new UserService();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> users = userService.getAllUsers();
		if(users==null || users.isEmpty())
		{
			response.sendRedirect("NoUsers.jsp");
			return;
		}
		request.setAttribute("users", users);
		request.getRequestDispatcher("DisplayUsers.jsp").forward(request, response);
	}
    



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

