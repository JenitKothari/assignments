<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment</title>
</head>
<body>
	<form action="PaymentController" method="post">
	Select Beneficiary
	<br><br>
		<select name="beneficiaryPayment">
		<c:forEach items="${beneficiariesPayment }" var="beneficiaryPayment">
    		<option value="${beneficiaryPayment.accountId }">
    			<c:out value="${beneficiaryPayment.name }"></c:out>
    			<c:out value="${beneficiaryPayment.accountNumber }"></c:out>
    			<c:out value="${beneficiaryPayment.ifsc }"></c:out>
    		</option>
    	</c:forEach>
  		</select>
  	<br><br>
  	Enter Amount
  	<input type="number" name="amount" step="0.01" min="0">
  	<button type="submit">Pay</button>
	</form>
	<br><br>
	 <a href="CustomerDashboard.jsp">
			<button>Back</button>
		</a>
<form action="LogoutController" method="post">
		<button type="submit" >Logout</button>
</form>
</body>
</html> --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment</title>
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container d-flex justify-content-center align-items-center vh-100">
    <div class="card shadow-lg p-4" style="width: 28rem; border-radius: 15px;">
        <div class="card-body">
            <h3 class="card-title text-primary mb-4 text-center">Make Payment</h3>

            <!-- Payment Form -->
            <form action="PaymentController" method="post" class="mb-4">
                <div class="mb-3">
                    <label for="beneficiaryPayment" class="form-label">Select Beneficiary</label>
                    <select name="beneficiaryPayment" id="beneficiaryPayment" class="form-select" required>
                        <c:forEach items="${beneficiariesPayment}" var="beneficiaryPayment">
                            <option value="${beneficiaryPayment.accountId}">
                                <c:out value="${beneficiaryPayment.name}"/> - 
                                <c:out value="${beneficiaryPayment.accountNumber}"/> - 
                                <c:out value="${beneficiaryPayment.ifsc}"/>
                            </option>
                        </c:forEach>
                    </select>
                </div>

                <div class="mb-3">
                    <label for="amount" class="form-label">Enter Amount</label>
                    <input type="number" name="amount" id="amount" class="form-control" step="0.01" min="0" required>
                </div>

                <div class="d-grid">
                    <button type="submit" class="btn btn-primary">Pay</button>
                </div>
            </form>

            <div class="d-grid gap-2 mb-2">
                <a href="CustomerDashboard.jsp" class="btn btn-secondary text-decoration-none">Back</a>
            </div>

            <form action="LogoutController" method="post" class="d-grid">
                <button type="submit" class="btn btn-danger">Logout</button>
            </form>

        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
