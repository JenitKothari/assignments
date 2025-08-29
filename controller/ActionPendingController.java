package com.aurionpro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.model.AccountDetails;
import com.aurionpro.model.ActionStatus;
import com.aurionpro.service.AccountDetailsService;


@WebServlet("/ActionPendingController")
public class ActionPendingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AccountDetailsService accountDetailsService = null;
 
    public ActionPendingController() {
        super();
        accountDetailsService = new AccountDetailsService();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pendingAccountId = Integer.parseInt(request.getParameter("pendingAccountId"));
		ActionStatus action = ActionStatus.valueOf(request.getParameter("action"));
		ActionStatus status = ActionStatus.valueOf(request.getParameter("status"));
		boolean updated=false;
		if(status == ActionStatus.PENDING)
		{
			System.out.println("Pending...");
			switch(action.name())
			{
			case "APPROVED":
				updated = accountDetailsService.updateStatus(ActionStatus.APPROVED, pendingAccountId);
				if(updated)
				{
					AccountDetails accountDetails = accountDetailsService.getPendingAccount(pendingAccountId);
					if(accountDetails!=null)
					{
						request.setAttribute("pendingAccount", accountDetails);
						request.getRequestDispatcher("AddApprovedAccountController").forward(request, response);
						return;
					}
				}
				response.sendRedirect("ApproveError.jsp");
				return;
			case "REJECTED":
				updated = accountDetailsService.updateStatus(ActionStatus.REJECTED, pendingAccountId);
				if(updated)
				{
					response.sendRedirect("GetPendingAccounts");
					return;
				}
				response.sendRedirect("RejectError.jsp");
				return;
			}
		}
		response.sendRedirect("GetPendingAccounts");
		return;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
