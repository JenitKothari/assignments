<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="LoginController" method="post">
		Login 
		<br> <br> 
		Username <input name="usernameTxt" type="text">
		<br> <br> 
		Password <input name="passwordTxt" type="password">
		<br> <br>
		<button type="submit">Login</button>
	</form>
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
<title>Login</title>

<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container d-flex justify-content-center align-items-center vh-100">
    <div class="card shadow-lg p-4" style="width: 28rem; border-radius: 15px;">
        <div class="card-body">
            <h3 class="card-title text-center text-primary mb-4">Banking App Login</h3>

            <!-- Login Form -->
            <form action="LoginController" method="post">
                <div class="mb-3">
                    <label for="usernameTxt" class="form-label">Username</label>
                    <input name="usernameTxt" type="text" class="form-control" id="usernameTxt" placeholder="Enter your username" required>
                </div>

                <div class="mb-3">
                    <label for="passwordTxt" class="form-label">Password</label>
                    <input name="passwordTxt" type="password" class="form-control" id="passwordTxt" placeholder="Enter your password" required>
                </div>

                <div class="d-grid gap-2">
                    <button type="submit" class="btn btn-primary">Login</button>
                </div>
            </form>

            <!-- Divider -->
            <hr class="my-4">

            <!-- Register Form -->
            <form action="RegisterUser.jsp" method="post" class="d-grid">
                <button type="submit" class="btn btn-outline-secondary">Register</button>
            </form>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
