package com.aurionpro.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.dao.BeneficiaryDao;
import com.aurionpro.model.BeneficiaryPayment;
import com.aurionpro.service.BeneficiaryService;


@WebServlet("/GetBeneficiariesController")
public class GetBeneficiariesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BeneficiaryService beneficiaryService = null;

    public GetBeneficiariesController() {
        super();
        beneficiaryService = new BeneficiaryService();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int accountId = (Integer)request.getSession().getAttribute("accountId");
		List<BeneficiaryPayment> beneficiariesPayment = beneficiaryService.getBeneficiaries(accountId);
		if(beneficiariesPayment==null || beneficiariesPayment.isEmpty())
		{
			response.sendRedirect("NoBeneficiaries.jsp");
			return;
		}
		request.setAttribute("beneficiariesPayment", beneficiariesPayment);
		request.getRequestDispatcher("Payment.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
