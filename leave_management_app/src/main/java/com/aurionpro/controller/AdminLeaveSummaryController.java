package com.aurionpro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.model.Leave;
import com.aurionpro.service.AdminLeaveSummaryService;


@WebServlet("/AdminLeaveSummaryController")
public class AdminLeaveSummaryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AdminLeaveSummaryService adminLeaveSummaryService = null;
	
    public AdminLeaveSummaryController() {
        super();
        adminLeaveSummaryService = new AdminLeaveSummaryService();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Leave> leaves = adminLeaveSummaryService.getAllLeaves();
		request.getSession().setAttribute("leaves", leaves);
		RequestDispatcher dispatcher = request.getRequestDispatcher("AdminPanel.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
