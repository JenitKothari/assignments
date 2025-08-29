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

@WebServlet("/GetPendingAccounts")
public class GetPendingAccounts extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AccountDetailsService accountDetailsService = null;   

    public GetPendingAccounts() {
        super();
        accountDetailsService = new AccountDetailsService();
    }


//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		List<AccountDetails> pendingAccounts = accountDetailsService.getPendingAccounts();
//		if(pendingAccounts==null || pendingAccounts.isEmpty())
//		{
//			response.sendRedirect("NoPendingAccounts.jsp");
//			return;
//		}
//		request.setAttribute("pendingAccounts", pendingAccounts);
//		request.getRequestDispatcher("DisplayPendingAccounts.jsp").forward(request, response);
//	}
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String statusFilter = request.getParameter("status"); // Can be null or empty
        
        List<AccountDetails> pendingAccounts = accountDetailsService.getPendingAccounts(statusFilter);
        
        if (pendingAccounts == null || pendingAccounts.isEmpty()) {
            response.sendRedirect("NoPendingAccounts.jsp");
            return;
        }
        
        request.setAttribute("pendingAccounts", pendingAccounts);
        request.getRequestDispatcher("DisplayPendingAccounts.jsp").forward(request, response);
    }



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
