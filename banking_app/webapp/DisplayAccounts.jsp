<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bank Accounts</title>
</head>
<body>
Bank Accounts
<form action="GetAllBankAccounts" method="get">
    <label>Account Number:</label>
    <input type="text" name="accountNumber" />

    <label>Balance Between:</label>
    <input type="number" step="0.01" name="minBalance" placeholder="Min Balance" />
    and
    <input type="number" step="0.01" name="maxBalance" placeholder="Max Balance" />

    <button type="submit">Apply Filter</button>
</form>


	<table>
		<tr>
			<th>Account Id</th>
			<th>User Id</th>
			<th>Name</th>
			<th>Account Number</th>
			<th>IFSC Code</th>
			<th>Mobile Number</th>
			<th>Address</th>
			<th>Balance</th>
		</tr>
		<c:forEach items="${accounts }" var="account">
			<tr>
				<td>${account.accountId }</td>
				<td>${account.userId }</td>
				<td>${account.name }</td>
				<td>${account.accountNumber }</td>
				<td>${account.ifsc }</td>
				<td>${account.mobileNumber }</td>
				<td>${account.address }</td>
				<td>${account.balance }</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<br>
	<a href="AdminDashboard.jsp">
		<button>Back</button>
	</a>
</body>
</html> --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bank Accounts</title>
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container my-5">
    <div class="card shadow-lg p-4" style="border-radius: 15px;">
        <div class="card-body">
            <h3 class="card-title text-primary mb-4 text-center">Bank Accounts</h3>

            <!-- Filter Form -->
            <form action="GetAllBankAccounts" method="get" class="row g-3 mb-4">
                <div class="col-12">
                    <label for="accountNumber" class="form-label">Account Number:</label>
                    <input type="text" name="accountNumber" id="accountNumber" class="form-control" placeholder="Enter Account Number">
                </div>

                <div class="col-md-6">
                    <label for="minBalance" class="form-label">Balance Between:</label>
                    <input type="number" step="0.01" name="minBalance" id="minBalance" class="form-control" placeholder="Min Balance">
                </div>
                <div class="col-md-6">
                    <label for="maxBalance" class="form-label">&nbsp;</label>
                    <input type="number" step="0.01" name="maxBalance" id="maxBalance" class="form-control" placeholder="Max Balance">
                </div>

                <div class="col-12 d-grid">
                    <button type="submit" class="btn btn-primary">Apply Filter</button>
                </div>
            </form>

            <!-- Accounts Table -->
            <div class="table-responsive">
                <table class="table table-bordered table-hover text-center align-middle">
                    <thead class="table-primary">
                        <tr>
                            <th>User Id</th>
                            <th>Name</th>
                            <th>Account Number</th>
                            <th>IFSC Code</th>
                            <th>Mobile Number</th>
                            <th>Address</th>
                            <th>Balance</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${accounts}" var="account">
                            <tr>
                                <td>${account.userId}</td>
                                <td>${account.name}</td>
                                <td>${account.accountNumber}</td>
                                <td>${account.ifsc}</td>
                                <td>${account.mobileNumber}</td>
                                <td>${account.address}</td>
                                <td>${account.balance}</td>
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
