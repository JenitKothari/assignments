<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pending Accounts</title>
</head>
<body>
Pending Accounts

<form action="GetPendingAccounts" method="get">
    <label for="status">Filter by Status:</label>
    <select name="status" id="status">
        <option value="">--All--</option>
        <option value="PENDING">Pending</option>
        <option value="APPROVED">Approved</option>
        <option value="REJECTED">Rejected</option>
    </select>
    <button type="submit">Filter</button>
</form>
<br>

<table>
		<tr>
			<th>Pending Account Id</th>
			<th>User Id</th>
			<th>Name</th>
			<th>IFSC Code</th>
			<th>Mobile Number</th>
			<th>Address</th>
			<th>Balance</th>
			<th>Status</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${pendingAccounts }" var="pendingAccount">
			<tr>
				<td>${pendingAccount.accountId}</td>
				<td>${pendingAccount.userId}</td>
				<td>${pendingAccount.name}</td>
				<td>${pendingAccount.ifsc}</td>
				<td>${pendingAccount.mobileNumber}</td>
				<td>${pendingAccount.address}</td>
				<td>${pendingAccount.balance}</td>
				<td>${pendingAccount.status}</td> 
				<td>
					<form action="ActionPendingController" method="post">
						<input type="hidden" name="pendingAccountId" value="${pendingAccount.accountId}">
						<input type="hidden" name="status" value="${pendingAccount.status }">
							<button type="submit" name="action" value="APPROVED">Approve</button>
							<button type="submit" name="action" value="REJECTED">Reject</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="AdminDashboard.jsp">
		<button>Back</button>
	</a>
</body>
</html> --%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pending Accounts</title>
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container my-5">
    <div class="card shadow-lg p-4" style="border-radius: 15px;">
        <div class="card-body">
            <h3 class="card-title text-primary mb-4 text-center">Pending Accounts</h3>

            <!-- Filter Form -->
            <form action="GetPendingAccounts" method="get" class="row g-3 mb-4">
                <div class="col-md-6">
                    <label for="status" class="form-label">Filter by Status:</label>
                    <select name="status" id="status" class="form-select">
                        <option value="">--All--</option>
                        <option value="PENDING">Pending</option>
                        <option value="APPROVED">Approved</option>
                        <option value="REJECTED">Rejected</option>
                    </select>
                </div>
                <div class="col-md-6 d-flex align-items-end">
                    <button type="submit" class="btn btn-primary w-100">Filter</button>
                </div>
            </form>

            <!-- Pending Accounts Table -->
            <div class="table-responsive">
                <table class="table table-bordered table-hover text-center align-middle">
                    <thead class="table-primary">
                        <tr>
                            <th>Pending Account Id</th>
                            <th>User Id</th>
                            <th>Name</th>
                            <th>IFSC Code</th>
                            <th>Mobile Number</th>
                            <th>Address</th>
                            <th>Balance</th>
                            <th>Status</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${pendingAccounts}" var="pendingAccount">
                            <tr>
                                <td>${pendingAccount.accountId}</td>
                                <td>${pendingAccount.userId}</td>
                                <td>${pendingAccount.name}</td>
                                <td>${pendingAccount.ifsc}</td>
                                <td>${pendingAccount.mobileNumber}</td>
                                <td>${pendingAccount.address}</td>
                                <td>${pendingAccount.balance}</td>
                                <td>${pendingAccount.status}</td>
                                <td>
                                    <form action="ActionPendingController" method="post" class="d-flex gap-2 justify-content-center">
                                        <input type="hidden" name="pendingAccountId" value="${pendingAccount.accountId}">
                                        <input type="hidden" name="status" value="${pendingAccount.status}">
                                        <button type="submit" name="action" value="APPROVED" class="btn btn-success btn-sm">Approve</button>
                                        <button type="submit" name="action" value="REJECTED" class="btn btn-danger btn-sm">Reject</button>
                                    </form>
                                </td>
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
