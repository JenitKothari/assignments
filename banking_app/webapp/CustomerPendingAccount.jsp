<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Pending</title>
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container d-flex justify-content-center align-items-center vh-100">
    <div class="card shadow-lg p-4 text-center" style="width: 28rem; border-radius: 15px;">
        <div class="card-body">
            <h3 class="card-title text-warning mb-4">Account Creation Pending</h3>
            <p class="mb-4">Your account creation request is still pending approval.</p>

            <div class="d-grid gap-2 mb-3">
                <a href="Login.jsp" class="btn btn-primary text-decoration-none">Back</a>
            </div>

            <form action="LogoutController" method="post">
                <div class="d-grid">
                    <button type="submit" class="btn btn-danger">Logout</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
