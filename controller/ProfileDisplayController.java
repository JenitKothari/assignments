package com.aurionpro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aurionpro.model.Profile;
import com.aurionpro.service.AccountDetailsService;


@WebServlet("/ProfileDisplayController")
public class ProfileDisplayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AccountDetailsService accountDetailsService = null;

    public ProfileDisplayController() {
        super();
        accountDetailsService = new AccountDetailsService();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int accountId = (Integer)request.getSession().getAttribute("accountId");
		Profile profile = accountDetailsService.getProfile(accountId);
		request.setAttribute("profile", profile);
		request.getRequestDispatcher("DisplayProfile.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
