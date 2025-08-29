package com.aurionpro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SelectAccountController")
public class SelectAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SelectAccountController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int accountId = Integer.parseInt(request.getParameter("selectedAccount"));
		request.getSession().setAttribute("accountId", accountId);
		response.sendRedirect("CustomerDashboard.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
