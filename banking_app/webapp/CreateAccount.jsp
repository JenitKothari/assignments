<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a New Account</title>
</head>
<body>
<form action="CreateAccountController" method="post">
	Name <input type="text" name="nameTxt">
	<br><br>
	Mobile Number <input type="text" name="mobileNumberTxt" pattern="[0-9]{10}" maxlength="10" minlength="10" title="Please enter exactly 10 numeric digits.">
	<br><br>
	Address <input type="text" name="addressTxt">
	<br><br>
	Initial Balance <input type="number" name="initialBalance" step="0.01" min="0">
	<br><br>
	<button type="submit">Create</button>
</form>
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
<title>Create a New Account</title>
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container d-flex justify-content-center align-items-center vh-100">
    <div class="card shadow-lg p-4" style="width: 28rem; border-radius: 15px;">
        <div class="card-body">
            <h3 class="card-title text-center text-primary mb-4">Create a New Account</h3>

            <!-- Create Account Form -->
            <form action="CreateAccountController" method="post">
                <div class="mb-3">
                    <label for="nameTxt" class="form-label">Name</label>
                    <input type="text" name="nameTxt" id="nameTxt" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label for="mobileNumberTxt" class="form-label">Mobile Number</label>
                    <input type="text" name="mobileNumberTxt" id="mobileNumberTxt" 
                           pattern="[0-9]{10}" maxlength="10" minlength="10" 
                           title="Please enter exactly 10 numeric digits." 
                           class="form-control" required>
                </div>

                <div class="mb-3">
                    <label for="addressTxt" class="form-label">Address</label>
                    <input type="text" name="addressTxt" id="addressTxt" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label for="initialBalance" class="form-label">Initial Balance</label>
                    <input type="number" name="initialBalance" id="initialBalance" 
                           step="0.01" min="0" class="form-control" required>
                </div>

                <div class="d-grid mb-3">
                    <button type="submit" class="btn btn-primary">Create</button>
                </div>
            </form>

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
