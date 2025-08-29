package com.aurionpro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.model.User;
import com.aurionpro.service.UserService;


@WebServlet("/RegisterUserController")
public class RegisterUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserService userService = null;

    public RegisterUserController() {
        super();
        userService = new UserService();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("usernameTxt");
		String password = request.getParameter("passwordTxt");
		String confirmPassword = request.getParameter("confirmPasswordTxt");
		if(!password.equals(confirmPassword))
		{
			response.sendRedirect("LoginError.jsp");
			return;
		}
		User user = new User(username,password);
		boolean registered = userService.registerUser(user);
		if(!registered)
		{
			response.sendRedirect("RegistrationError.jsp");
			return;
		}
		response.sendRedirect("RegistrationSuccessful.jsp");
		return;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
