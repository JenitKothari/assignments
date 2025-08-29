package com.aurionpro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.service.AccountDetailsService;


@WebServlet("/PaymentController")
public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AccountDetailsService accountDetailsService = null;   

    public PaymentController() {
        super();
        accountDetailsService = new AccountDetailsService();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int senderAccountId = (Integer)request.getSession().getAttribute("accountId");
		int recieverAccountId = Integer.parseInt(request.getParameter("beneficiaryPayment"));
		double amount = Double.parseDouble(request.getParameter("amount"));
		
		boolean paid = accountDetailsService.makePayment(senderAccountId, recieverAccountId, amount);
		if(!paid)
		{
			response.sendRedirect("PaymentFail.jsp");
			return;
		}
		
		response.sendRedirect("PaymentSuccess.jsp");
		return;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
