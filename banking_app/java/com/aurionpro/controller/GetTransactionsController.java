//package com.aurionpro.controller;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.aurionpro.model.Transaction;
//import com.aurionpro.service.TransactionService;
//
//@WebServlet("/GetTransactionsController")
//public class GetTransactionsController extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//    private TransactionService transactionService = null;
//
//    public GetTransactionsController() {
//        super();
//        transactionService = new TransactionService();
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // session attributes (keep same as your project)
//        HttpSession session = request.getSession(false);
//        if (session == null || session.getAttribute("userId") == null) {
//            response.sendRedirect("Login.jsp");
//            return;
//        }
//
//        Integer accountIdObj = (Integer) session.getAttribute("accountId"); // may be null depending on flow
//        int accountId = (accountIdObj != null) ? accountIdObj.intValue() : -1;
//        int userId = (Integer) session.getAttribute("userId");
//
//        // read filter parameters (GET or POST routed here)
//        String fromDate = request.getParameter("fromDate");        // yyyy-MM-dd
//        String toDate = request.getParameter("toDate");            // yyyy-MM-dd
//        String minAmountStr = request.getParameter("minAmount");
//        String maxAmountStr = request.getParameter("maxAmount");
//        String type = request.getParameter("type");                // CREDIT | DEBIT | null/empty
//        String filterAccountIdStr = request.getParameter("filterAccountId"); // for admin use
//
//        // pass to service (service will handle null/empty parsing)
//        List<Transaction> transactions = transactionService.getFilteredTransactions(
//                accountId, userId,
//                fromDate, toDate,
//                minAmountStr, maxAmountStr,
//                type, filterAccountIdStr
//        );
//
//        request.setAttribute("transactions", transactions);
//        RequestDispatcher rd = request.getRequestDispatcher("DisplayTransactions.jsp");
//        rd.forward(request, response);
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request, response);
//    }
//}


package com.aurionpro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aurionpro.model.Transaction;
import com.aurionpro.model.User;
import com.aurionpro.service.TransactionService;

@WebServlet("/GetTransactionsController")
public class GetTransactionsController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private TransactionService transactionService = new TransactionService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("userId") == null) {
            response.sendRedirect("Login.jsp");
            return;
        }

        int userId = (Integer) session.getAttribute("userId");
        User user = (User) session.getAttribute("user"); // may be null if you didn't store it

        // accountId may be stored in session by your login flow; prefer that if available
        Integer sessionAccountId = (session.getAttribute("accountId") instanceof Integer)
                ? (Integer) session.getAttribute("accountId")
                : null;

        // Read filter parameters (form method can be GET or POST — this handles GET)
        String fromDate = request.getParameter("fromDate");     // yyyy-MM-dd
        String toDate = request.getParameter("toDate");         // yyyy-MM-dd
        String minAmount = request.getParameter("minAmount");
        String maxAmount = request.getParameter("maxAmount");
        String type = request.getParameter("type");             // CREDIT | DEBIT | null/empty
        String filterAccountId = request.getParameter("filterAccountId"); // admin-only

        // Call service — if user not admin, service/dao will ensure restriction to user's account
        List<Transaction> transactions = transactionService.getFilteredTransactions(
                userId,
                sessionAccountId,   // may be null
                fromDate,
                toDate,
                minAmount,
                maxAmount,
                type,
                filterAccountId
        );

        request.setAttribute("transactions", transactions);
        RequestDispatcher rd = request.getRequestDispatcher("DisplayTransactions.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // keep behaviour same as GET to simplify form handling
        doGet(request, response);
    }
}
