<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accounts</title>
</head>
<body>
	<c:if test="${not empty customerAccounts }">
		<form action="SelectAccountController" method="post">
			Select Account 
			<select name="selectedAccount">
				<c:forEach items="${customerAccounts }" var="account">
					<option value="${account.getAccountId() }">${account.getAccountNumber() }</option>
				</c:forEach>
			</select>
			<button>Next</button>
		</form>
	</c:if>
	<br><br>
	<a href="CreateAccount.jsp">
		<button>Create New Account</button>
	</a>
	<br><br>
<form action="LogoutController" method="post">
		<button type="submit" >Logout</button>
</form>
</body>
</html> --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accounts</title>
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container d-flex justify-content-center align-items-center vh-100">
    <div class="card shadow-lg p-4" style="width: 28rem; border-radius: 15px;">
        <div class="card-body">
            <h3 class="card-title text-center text-primary mb-4">Your Accounts</h3>

            <!-- Select Existing Account -->
            <c:if test="${not empty customerAccounts}">
                <form action="SelectAccountController" method="post" class="mb-3">
                    <div class="mb-3">
                        <label for="selectedAccount" class="form-label">Select Account</label>
                        <select name="selectedAccount" id="selectedAccount" class="form-select" required>
                            <c:forEach items="${customerAccounts}" var="account">
                                <option value="${account.getAccountId()}">${account.getAccountNumber()}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="d-grid">
                        <button type="submit" class="btn btn-primary">Next</button>
                    </div>
                </form>
            </c:if>

            <hr class="my-4">

            <!-- Create New Account -->
            <div class="d-grid mb-3">
                <a href="CreateAccount.jsp" class="btn btn-outline-secondary text-decoration-none">Create New Account</a>
            </div>

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
