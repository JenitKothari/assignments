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
import com.aurionpro.service.EmployeeLeaveSummaryService;


@WebServlet("/EmployeeLeaveSummaryController")
public class EmployeeLeaveSummaryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EmployeeLeaveSummaryService employeeLeaveSummaryService = null;

    public EmployeeLeaveSummaryController() {
        super();
        employeeLeaveSummaryService = new EmployeeLeaveSummaryService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = (Integer) request.getSession().getAttribute("userId");
		List<Leave> leaves = employeeLeaveSummaryService.getAllLeaves(userId); 
		request.setAttribute("leaves", leaves);
		RequestDispatcher dispatcher = request.getRequestDispatcher("EmployeeLeaveSummary.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
