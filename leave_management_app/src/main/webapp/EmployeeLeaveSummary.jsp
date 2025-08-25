<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Leaves</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">

    <h2 class="mb-4 text-center">Leaves Applied</h2>

    <table class="table table-bordered table-striped">
        <thead class="table-dark">
            <tr>
                <th>Date</th>
                <th>No of Days</th>
                <th>Reason</th>
                <th>Status</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${leaves}" var="leave">
                <tr>
                    <td>${leave.getAppliedAt()}</td>
                    <td>${leave.getNoOfDays()}</td>
                    <td>${leave.getReason()}</td>
                    <td>
                        <span class="badge 
                            <c:choose>
                                <c:when test='${leave.getStatus() eq "APPROVED"}'>bg-success</c:when>
                                <c:when test='${leave.getStatus() eq "REJECTED"}'>bg-danger</c:when>
                                <c:otherwise>bg-warning text-dark</c:otherwise>
                            </c:choose>">
                            ${leave.getStatus()}
                        </span>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <div class="mt-3">
        <a href="EmployeePanel.jsp" class="btn btn-primary">Back</a>
    </div>

</body>
</html>
