<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Error</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light d-flex justify-content-center align-items-center vh-100">

    <div class="card shadow-lg border-danger text-center" style="max-width: 400px;">
        <div class="card-header bg-danger text-white">
            <h4>Error</h4>
        </div>
        <div class="card-body">
            <p class="text-danger fw-bold mb-3">Beneficiary can’t be added.</p>
            <a href="AddBeneficiary.jsp" class="btn btn-primary">Try Again</a>
            <a href="CustomerDashboard.jsp" class="btn btn-secondary ms-2">Back</a>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
