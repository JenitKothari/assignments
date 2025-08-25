<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Panel</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

	<div class="container mt-5">
		<h2 class="text-center mb-4">Employee Panel</h2>

		<div class="card shadow-sm mb-4">
			<div class="card-body">
				<h5 class="card-title">Apply for Leave</h5>
				<form action="LeaveApplyController" method="post" class="row g-3">
					<div class="col-md-6">
						<label class="form-label">From</label>
						<input type="date" class="form-control" name="fromDate">
					</div>
					<div class="col-md-6">
						<label class="form-label">To</label>
						<input type="date" class="form-control" name="toDate">
					</div>
					<div class="col-12">
						<label class="form-label">Reason</label>
						<input type="text" class="form-control" name="reasonTxt" placeholder="Enter reason">
					</div>
					<div class="col-12">
						<button class="btn btn-primary" type="submit">Apply</button>
					</div>
				</form>
			</div>
		</div>

		<div class="d-flex justify-content-between">
			<form action="EmployeeLeaveSummaryController" method="post">
				<button class="btn btn-info">Leave Summary</button>
			</form>
			<form action="LogoutController" method="post">
				<button class="btn btn-danger">Logout</button>
			</form>
		</div>
	</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
