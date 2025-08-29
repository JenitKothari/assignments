<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Details</title>
</head>
<body>
Account Number : <c:out value="${accountInfo.getAccountNumber() }"></c:out>
<br><br>

IFSC Code : <c:out value="${accountInfo.getIfsc() }"></c:out>
<br><br>

Balance : <c:out value="${accountInfo.getBalance() }"></c:out>
<br><br>

<a href="CustomerDashboard.jsp"><button>Back</button></a>
</body>
</html> --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Details</title>
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container d-flex justify-content-center align-items-center vh-100">
    <div class="card shadow-lg p-4" style="width: 28rem; border-radius: 15px;">
        <div class="card-body">
            <h3 class="card-title text-primary mb-4 text-center">Account Details</h3>

            <div class="mb-3">
                <strong>Account Number:</strong>
                <span class="d-block"><c:out value="${accountInfo.getAccountNumber()}"/></span>
            </div>

            <div class="mb-3">
                <strong>IFSC Code:</strong>
                <span class="d-block"><c:out value="${accountInfo.getIfsc()}"/></span>
            </div>

            <div class="mb-3">
                <strong>Balance:</strong>
                <span class="d-block"><c:out value="${accountInfo.getBalance()}"/></span>
            </div>

            <div class="d-grid mt-4">
                <a href="CustomerDashboard.jsp" class="btn btn-primary text-decoration-none">Back</a>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
