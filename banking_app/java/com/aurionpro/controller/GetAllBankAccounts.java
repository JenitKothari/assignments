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


@WebServlet("/GetAllBankAccounts")
public class GetAllBankAccounts extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AccountDetailsService accountDetailsService = null;  
  
    public GetAllBankAccounts() {
        super();
        accountDetailsService = new AccountDetailsService();
    }


//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		List<AccountDetails> accounts = accountDetailsService.getAllBankAccounts();
//		if(accounts==null || accounts.isEmpty())
//		{
//			response.sendRedirect("NoAccounts.jsp");
//			return;
//		}
//		request.setAttribute("accounts", accounts);
//		request.getRequestDispatcher("DisplayAccounts.jsp").forward(request, response);
//	}
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountNumber = request.getParameter("accountNumber");
        String minBalStr = request.getParameter("minBalance");
        String maxBalStr = request.getParameter("maxBalance");

        Double minBalance = (minBalStr != null && !minBalStr.isEmpty()) ? Double.parseDouble(minBalStr) : null;
        Double maxBalance = (maxBalStr != null && !maxBalStr.isEmpty()) ? Double.parseDouble(maxBalStr) : null;

        List<AccountDetails> accounts = accountDetailsService.getFilteredBankAccounts(accountNumber, minBalance, maxBalance);

        if (accounts == null || accounts.isEmpty()) {
            response.sendRedirect("NoAccounts.jsp");
            return;
        }

        request.setAttribute("accounts", accounts);
        request.getRequestDispatcher("DisplayAccounts.jsp").forward(request, response);
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
