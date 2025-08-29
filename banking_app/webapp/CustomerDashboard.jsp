<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Dashboard</title>
</head>
<body>
<a href="ProfileDisplayController">Profile</a>
<br><br>
<a href="DisplayAccountDetailsController">Account Details</a>
<br><br>
<a href="AddBeneficiary.jsp">Add beneficiary</a>
<br><br>
<a href="GetBeneficiariesController">Make Payment</a>
<br><br>
<a href="GetTransactionsController">Statement</a>
<br><br>

<form action="LogoutController" method="post">
		<button type="submit" >Logout</button>
</form>
</body>
</html> --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Dashboard</title>
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container d-flex justify-content-center align-items-center vh-100">
    <div class="card shadow-lg p-4" style="width: 28rem; border-radius: 15px;">
        <div class="card-body text-center">
            <h3 class="card-title text-primary mb-4">Customer Dashboard</h3>

            <!-- Dashboard Links -->
            <div class="d-grid gap-2 mb-3">
                <a href="ProfileDisplayController" class="btn btn-outline-primary">Profile</a>
                <a href="DisplayAccountDetailsController" class="btn btn-outline-primary">Account Details</a>
                <a href="AddBeneficiary.jsp" class="btn btn-outline-primary">Add Beneficiary</a>
                <a href="GetBeneficiariesController" class="btn btn-outline-primary">Make Payment</a>
                <a href="GetTransactionsController" class="btn btn-outline-primary">Statement</a>
            </div>

            <hr class="my-3">

            <!-- Logout -->
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
