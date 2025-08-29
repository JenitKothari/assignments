<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container d-flex justify-content-center align-items-center vh-100">
    <div class="card shadow-lg p-4 text-center" style="width: 28rem; border-radius: 15px;">
        <div class="card-body">
            <h3 class="card-title text-danger mb-4">Error</h3>
            <p class="mb-4">Account can't be created!</p>
            <a href="CreateAccount.jsp" class="btn btn-primary">Try Again</a>
            <a href="LogoutController" class="btn btn-danger ms-2">Logout</a>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
