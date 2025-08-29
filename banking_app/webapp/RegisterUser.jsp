<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<form action="RegisterUserController" method="post">
		User Registration
		<br><br> 
		Username <input type="text" name="usernameTxt"> 
		<br><br>
		Password <input type="password" name="passwordTxt">
		<br><br>
		Confirm Password <input type="password" name="confirmPasswordTxt">
		<br><br>
		<button type="submit">Register</button>
	</form>
</body>
</html> --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container d-flex justify-content-center align-items-center vh-100">
    <div class="card shadow-lg p-4" style="width: 28rem; border-radius: 15px;">
        <div class="card-body">
            <h3 class="card-title text-primary mb-4 text-center">User Registration</h3>

            <!-- Registration Form -->
            <form action="RegisterUserController" method="post">
                <div class="mb-3">
                    <label for="usernameTxt" class="form-label">Username</label>
                    <input type="text" name="usernameTxt" id="usernameTxt" class="form-control" placeholder="Enter username" required>
                </div>

                <div class="mb-3">
                    <label for="passwordTxt" class="form-label">Password</label>
                    <input type="password" name="passwordTxt" id="passwordTxt" class="form-control" placeholder="Enter password" required>
                </div>

                <div class="mb-3">
                    <label for="confirmPasswordTxt" class="form-label">Confirm Password</label>
                    <input type="password" name="confirmPasswordTxt" id="confirmPasswordTxt" class="form-control" placeholder="Confirm password" required>
                </div>

                <div class="d-grid">
                    <button type="submit" class="btn btn-primary">Register</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
