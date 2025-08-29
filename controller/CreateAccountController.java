package com.aurionpro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.model.AccountDetails;
import com.aurionpro.service.AccountDetailsService;
import com.aurionpro.util.Utility;


@WebServlet("/CreateAccountController")
public class CreateAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AccountDetailsService accountDetailsService = null;

    public CreateAccountController() {
        super();
        accountDetailsService = new AccountDetailsService();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		int userId = (Integer)request.getSession().getAttribute("userId");
//		String name = request.getParameter("nameTxt");
//		String accountNumber = "temp";
//		String ifsc = "SBI01";
//		String mobileNumber = request.getParameter("mobileNumberTxt");
//		String address = request.getParameter("addressTxt");
//		double balance = Double.parseDouble(request.getParameter("initialBalance"));
		
		int userId = (Integer)request.getSession().getAttribute("userId");
		String name = request.getParameter("nameTxt");
		String ifsc = "SBI01";
		String mobileNumber = request.getParameter("mobileNumberTxt");
		String address = request.getParameter("addressTxt");
		double balance = Double.parseDouble(request.getParameter("initialBalance"));
		
		AccountDetails accountDetails = new AccountDetails(userId, name, ifsc, mobileNumber, address, balance);
		boolean added = accountDetailsService.addPendingAccounts(accountDetails);
		if(!added)
			{
				response.sendRedirect("CreateAccountError.jsp");
				return;
			}
			response.sendRedirect("CustomerPendingAccount.jsp");
		
//		boolean added = accountDetailsService.addAccountDetails(accountDetails);
//		if(!added)
//		{
//			response.sendRedirect("CreateAccountError.jsp");
//			return;
//		}
//		response.sendRedirect("CustomerAccountsController");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
