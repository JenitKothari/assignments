<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="com.aurionpro.model.User" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>
</head>
<body>

<%
    User user = (User) session.getAttribute("user");

    if (user == null || !user.isAdmin()) {  
        // No session, redirect to login
        response.sendRedirect("Login.jsp");
        return;
    }
%>

<a href="GetAllUsersController">View All Users</a>
<br><br>
<a href="GetAllBankAccounts">View All Bank Accounts</a>
<br><br>
<a href="GetTransactionsController">View All Transactions</a>
<br><br>
<a href="GetPendingAccounts">Approve Account</a>
<br><br>
<form action="LogoutController" method="post">
		<button type="submit" >Logout</button>
</form>
</body>
</html>
  --%>
  
  <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.aurionpro.model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<%
    User user = (User) session.getAttribute("user");

    if (user == null || !user.isAdmin()) {  
        response.sendRedirect("Login.jsp");
        return;
    }
%>

<div class="container mt-5">
    <div class="card shadow-lg border-0">
        <div class="card-header bg-primary text-white text-center">
            <h3>Admin Dashboard</h3>
        </div>
        <div class="card-body text-center">
            <div class="d-grid gap-3 col-6 mx-auto">
                <a href="GetAllUsersController" class="btn btn-primary">View All Users</a>
                <a href="GetAllBankAccounts" class="btn btn-primary">View All Bank Accounts</a>
                <a href="GetTransactionsController" class="btn btn-primary">View All Transactions</a>
                <a href="GetPendingAccounts" class="btn btn-primary">Approve Accounts</a>
            </div>
        </div>
        <div class="card-footer text-center">
            <form action="LogoutController" method="post">
                <button type="submit" class="btn btn-danger w-50">Logout</button>
            </form>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
