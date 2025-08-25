package com.aurionpro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.model.LeaveStatus;
import com.aurionpro.service.AdminLeaveSummaryService;


@WebServlet("/AdminActionController")
public class AdminActionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AdminLeaveSummaryService adminLeaveSummaryService = null;

    public AdminActionController() {
        super();
        adminLeaveSummaryService = new AdminLeaveSummaryService();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int leaveId = Integer.parseInt(request.getParameter("leaveId"));
		String status = request.getParameter("action");
		boolean updated = adminLeaveSummaryService.updateStatus(leaveId, status);
		response.sendRedirect("AdminLeaveSummaryController");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
