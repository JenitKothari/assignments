package com.aurionpro.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.model.Leave;
import com.aurionpro.model.LeaveStatus;
import com.aurionpro.service.EmployeeLeaveSummaryService;


@WebServlet("/LeaveApplyController")
public class LeaveApplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EmployeeLeaveSummaryService employeeLeaveSummaryService = null;
    
    public LeaveApplyController() {
        super();
        employeeLeaveSummaryService = new EmployeeLeaveSummaryService();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = (Integer) request.getSession().getAttribute("userId");
		LocalDate fromDate = LocalDate.parse(request.getParameter("fromDate"));
		LocalDate toDate = LocalDate.parse(request.getParameter("toDate"));
		String reason = request.getParameter("reasonTxt");
		LeaveStatus status = LeaveStatus.PENDING;
		Leave leave = new Leave(userId, fromDate, toDate, reason, status);
		boolean isAdded = employeeLeaveSummaryService.addLeave(leave);
		if(!isAdded)
		{
			response.sendRedirect("AddLeaveError.jsp");
			return;
		}
		request.getRequestDispatcher("EmployeePanel.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
