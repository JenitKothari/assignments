package com.aurionpro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.model.AccountDetails;
import com.aurionpro.service.AccountDetailsService;


@WebServlet("/CustomerAccountsController")
public class CustomerAccountsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AccountDetailsService accountDetailsService = null;

    public CustomerAccountsController() {
        super();
        accountDetailsService = new AccountDetailsService();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = (Integer) request.getSession().getAttribute("userId");
		List<AccountDetails> customerAccounts = accountDetailsService.fetchAllAccounts(userId);
		request.setAttribute("customerAccounts", customerAccounts);
		request.getRequestDispatcher("ChooseCustomerAccount.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
