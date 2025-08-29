<%--  
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transactions</title>
</head>
<body>

<h2>Filter Transactions</h2>
<form action="GetTransactionsController" method="get">
    From Date:
    <input type="date" name="fromDate" value="${param.fromDate}"> &nbsp;
    To Date:
    <input type="date" name="toDate" value="${param.toDate}"> &nbsp;
    Min Amount:
    <input type="number" step="0.01" name="minAmount" value="${param.minAmount}"> &nbsp;
    Max Amount:
    <input type="number" step="0.01" name="maxAmount" value="${param.maxAmount}"> &nbsp;
    Type:
    <select name="type">
        <option value="">All</option>
        <option value="CREDIT" ${param.type == 'CREDIT' ? 'selected' : ''}>CREDIT</option>
        <option value="DEBIT" ${param.type == 'DEBIT' ? 'selected' : ''}>DEBIT</option>
    </select> &nbsp;
    <c:if test="${sessionScope.user != null && sessionScope.user.admin == true}">
        Account Id:
        <input type="number" name="filterAccountId" value="${param.filterAccountId}"> &nbsp;
    </c:if>
    <button type="submit">Apply Filters</button>
</form>

<hr>

<c:if test="${empty transactions}">
    <p>No transactions found.</p>
</c:if>

<c:if test="${not empty transactions}">
    <table border="1" cellpadding="6" cellspacing="0">
        <tr>
            <th>Transaction Id</th>
            <th>Account Id</th>
            <th>Date</th>
            <th>Other Account Id</th>
            <th>Type</th>
            <th>Amount</th>
        </tr>
        <c:forEach items="${transactions}" var="transaction">
            <tr>
                <td><c:out value="${transaction.transactionId}"/></td>
                <td><c:out value="${transaction.accountId}"/></td>
                <td><c:out value="${transaction.txnDate}"/></td>
                <td><c:out value="${transaction.otherAccountId}"/></td>
                <td><c:out value="${transaction.type}"/></td>
                <td><c:out value="${transaction.amount}"/></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

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
<title>Transactions</title>
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container my-5">
    <div class="card shadow-lg p-4" style="border-radius: 15px;">
        <div class="card-body">
            <h3 class="card-title text-primary mb-4 text-center">Transactions</h3>

            <!-- Filter Form -->
            <form action="GetTransactionsController" method="get" class="row g-3 mb-4">
                <div class="col-md-3">
                    <label for="fromDate" class="form-label">From Date</label>
                    <input type="date" name="fromDate" id="fromDate" class="form-control" value="${param.fromDate}">
                </div>
                <div class="col-md-3">
                    <label for="toDate" class="form-label">To Date</label>
                    <input type="date" name="toDate" id="toDate" class="form-control" value="${param.toDate}">
                </div>
                <div class="col-md-3">
                    <label for="minAmount" class="form-label">Min Amount</label>
                    <input type="number" step="0.01" name="minAmount" id="minAmount" class="form-control" value="${param.minAmount}">
                </div>
                <div class="col-md-3">
                    <label for="maxAmount" class="form-label">Max Amount</label>
                    <input type="number" step="0.01" name="maxAmount" id="maxAmount" class="form-control" value="${param.maxAmount}">
                </div>
                <div class="col-md-3">
                    <label for="type" class="form-label">Type</label>
                    <select name="type" id="type" class="form-select">
                        <option value="">All</option>
                        <option value="CREDIT" ${param.type == 'CREDIT' ? 'selected' : ''}>CREDIT</option>
                        <option value="DEBIT" ${param.type == 'DEBIT' ? 'selected' : ''}>DEBIT</option>
                    </select>
                </div>
                <c:if test="${sessionScope.user != null && sessionScope.user.admin == true}">
                    <div class="col-md-3">
                        <label for="filterAccountId" class="form-label">Account Id</label>
                        <input type="number" name="filterAccountId" id="filterAccountId" class="form-control" value="${param.filterAccountId}">
                    </div>
                </c:if>
                <div class="col-12 d-grid">
                    <button type="submit" class="btn btn-primary">Apply Filters</button>
                </div>
            </form>

            <hr>

            <!-- Transactions Table -->
            <c:if test="${empty transactions}">
                <p class="text-center text-muted">No transactions found.</p>
            </c:if>

            <c:if test="${not empty transactions}">
                <div class="table-responsive">
                    <table class="table table-bordered table-hover text-center align-middle">
                        <thead class="table-primary">
                            <tr>
                                <th>Transaction Id</th>
                                <th>Account Id</th>
                                <th>Date</th>
                                <th>Other Account Id</th>
                                <th>Type</th>
                                <th>Amount</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${transactions}" var="transaction">
                                <tr>
                                    <td><c:out value="${transaction.transactionId}"/></td>
                                    <td><c:out value="${transaction.accountId}"/></td>
                                    <td><c:out value="${transaction.txnDate}"/></td>
                                    <td><c:out value="${transaction.otherAccountId}"/></td>
                                    <td><c:out value="${transaction.type}"/></td>
                                    <td><c:out value="${transaction.amount}"/></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:if>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
  