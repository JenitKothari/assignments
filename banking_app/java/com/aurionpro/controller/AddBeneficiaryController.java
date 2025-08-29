package com.aurionpro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.model.Beneficiary;
import com.aurionpro.service.BeneficiaryService;


@WebServlet("/AddBeneficiaryController")
public class AddBeneficiaryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BeneficiaryService beneficiaryService = null;

    public AddBeneficiaryController() {
        super();
        beneficiaryService = new BeneficiaryService();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int accountId = (Integer)request.getSession().getAttribute("accountId");
		
		String accountNumber = request.getParameter("accountNumberTxt");
		String ifsc = request.getParameter("ifscTxt");
		String bankName = request.getParameter("bankNameTxt");
		String beneficiaryName = request.getParameter("beneficiaryNameTxt");
		
		Beneficiary beneficiary = new Beneficiary(bankName,beneficiaryName);
		boolean added = beneficiaryService.addBeneficiary(beneficiary, accountNumber, ifsc, accountId);
		if(!added)
		{
			response.sendRedirect("AddBeneficiaryError.jsp");
			return;
		}
		response.sendRedirect("AddBeneficiarySuccessul.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
