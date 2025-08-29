<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
</head>
<body>
Name : <c:out value="${profile.getName() }"></c:out>
<br><br>

Mobile Number : <c:out value="${profile.getMobileNumber() }"></c:out>
<br><br>

Address : <c:out value="${profile.getAddress() }"></c:out>
<br><br>

<a href="CustomerDashboard.jsp"><button>Back</button></a>
</body>
 --%>
 
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container d-flex justify-content-center align-items-center vh-100">
	<div class="card shadow-lg p-4" style="width: 28rem; border-radius: 15px;">
		<div class="card-body">
			<h3 class="card-title text-primary mb-4 text-center">Profile</h3>

			<div class="mb-3">
				<strong>Name:</strong>
				<span class="d-block"><c:out value="${profile.getName()}"/></span>
			</div>

			<div class="mb-3">
				<strong>Mobile Number:</strong>
				<span class="d-block"><c:out value="${profile.getMobileNumber()}"/></span>
			</div>

			<div class="mb-3">
				<strong>Address:</strong>
				<span class="d-block"><c:out value="${profile.getAddress()}"/></span>
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
 