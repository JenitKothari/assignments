<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="com.aurionpro.model.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Beneficiary</title>
</head>
<body>

	<form action="AddBeneficiaryController" method="post">
		Account Number <input type="text" name="accountNumberTxt"> <br>
		<br> IFSC Code <input type="text" name="ifscTxt"> <br>
		<br> Bank Name <input type="text" name="bankNameTxt"> <br>
		<br> Beneficiary Name <input type="text"
			name="beneficiaryNameTxt"> <br>
		<br>
		<button type="submit">Add</button>
	
	</form>
		<br>
		<br> <a href="CustomerDashboard.jsp">
			<button>Back</button>
		</a>
</body>
</html> --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.aurionpro.model.User" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Add New Beneficiary</title>
	<!-- Bootstrap CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card shadow-lg rounded-3">
					<div class="card-header bg-primary text-white text-center">
						<h4>Add New Beneficiary</h4>
					</div>
					<div class="card-body">
						<form action="AddBeneficiaryController" method="post">
							
							<div class="mb-3">
								<label class="form-label">Account Number</label>
								<input type="text" name="accountNumberTxt" class="form-control" placeholder="Enter account number" required>
							</div>
							
							<div class="mb-3">
								<label class="form-label">IFSC Code</label>
								<input type="text" name="ifscTxt" class="form-control" placeholder="Enter IFSC code" required>
							</div>
							
							<div class="mb-3">
								<label class="form-label">Bank Name</label>
								<input type="text" name="bankNameTxt" class="form-control" placeholder="Enter bank name" required>
							</div>
							
							<div class="mb-3">
								<label class="form-label">Beneficiary Name</label>
								<input type="text" name="beneficiaryNameTxt" class="form-control" placeholder="Enter beneficiary name" required>
							</div>
							
							<div class="d-grid">
								<button type="submit" class="btn btn-success">Add Beneficiary</button>
							</div>
						</form>
					</div>
					<div class="card-footer text-center">
						<a href="CustomerDashboard.jsp" class="btn btn-secondary">Back</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap JS -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
