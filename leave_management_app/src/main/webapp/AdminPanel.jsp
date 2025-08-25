<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Panel</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" 
      rel="stylesheet">
</head>
<body class="container mt-4">

	<h2 class="mb-4">Leaves Applied</h2>

	<table class="table table-bordered table-striped">
		<thead class="table-dark">
			<tr>
				<th>Employee ID</th>
				<th>Name</th>
				<th>No of Days</th>
				<th>From</th>
				<th>To</th>
				<th>Reason</th>
				<th>Status</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${leaves}" var="leave">
				<tr>
					<td>${leave.getUserId()}</td>
					<td>${leave.getEmployeeName()}</td>
					<td>${leave.getNoOfDays()}</td>
					<td>${leave.getFromDate() }</td>
					<td>${leave.getToDate() }</td>
					<td>${leave.getReason() }</td>
					<td>
						<span class="badge 
							${leave.getStatus() == 'APPROVED' ? 'bg-success' : 
							  leave.getStatus() == 'REJECTED' ? 'bg-danger' : 'bg-secondary'}">
							${leave.getStatus() }
						</span>
					</td>
					<td>
						<form action="AdminActionController" method="post" class="d-flex gap-2">
							<input type="hidden" name="leaveId" value="${leave.leaveId}">
							<button type="submit" name="action" value="APPROVED" 
							        class="btn btn-sm btn-success">Approve</button>
							<button type="submit" name="action" value="REJECTED" 
							        class="btn btn-sm btn-danger">Reject</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<form action="LogoutController" method="post" class="mt-3">
		<button type="submit" class="btn btn-outline-secondary">Logout</button>
	</form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
