<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users</title>
</head>
<body>
	Users
	<table>
		<tr>
			<th>User Id</th>
			<th>Username</th>
		</tr>
		<c:forEach items="${users }" var="user">
			<tr>
				<td>${user.userId }</td>
				<td>${user.username }</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<br>
	<a href="AdminDashboard.jsp">
		<button>Back</button>
	</a>
</body>
</html> 
 --%>
 
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users</title>
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container my-5">
    <div class="card shadow-lg p-4" style="border-radius: 15px;">
        <div class="card-body">
            <h3 class="card-title text-primary mb-4 text-center">Users</h3>

            <!-- Users Table -->
            <div class="table-responsive">
                <table class="table table-bordered table-hover text-center align-middle">
                    <thead class="table-primary">
                        <tr>
                            <th>User Id</th>
                            <th>Username</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${users}" var="user">
                            <tr>
                                <td>${user.userId}</td>
                                <td>${user.username}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

            <div class="d-grid mt-4">
                <a href="AdminDashboard.jsp" class="btn btn-secondary text-decoration-none">Back</a>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
 