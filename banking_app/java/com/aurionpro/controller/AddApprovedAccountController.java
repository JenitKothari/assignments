package com.aurionpro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.model.AccountDetails;
import com.aurionpro.service.AccountDetailsService;


@WebServlet("/AddApprovedAccountController")
public class AddApprovedAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AccountDetailsService accountDetailsService = null;

    public AddApprovedAccountController() {
        super();
        accountDetailsService = new AccountDetailsService();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountDetails account = (AccountDetails) request.getAttribute("pendingAccount");
		String accountNumber = "temp";
		account.setAccountNumber(accountNumber);
		boolean added = accountDetailsService.addAccountDetails(account);
		if(!added)
		{
			response.sendRedirect("ApproveError.jsp");
			return;
		}
		response.sendRedirect("GetPendingAccounts");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
