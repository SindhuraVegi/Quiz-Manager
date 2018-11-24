<%@page import="fr.epita.quiz.datamodel.Users"%>
<%@page import="fr.epita.quiz.services.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<!DOCTYPE html>
<html>
<%
 Users user = (Users) session.getAttribute("user");
%>
<head>
<meta charset="ISO-8859-1">
<title>Quiz manager application</title>
	<link rel="stylesheet" href="resources/css/style.css">
			<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<h1 align="center">Change Password</h1>
	<div class="container">

		<form action="forgotPassword" method="post">
		<div class="form-group row">
				 <input name="id"
					value="<%=user.getUserRoleId()%>" type="hidden" class="form-control"
					id="id" readonly="readonly" />
			</div>
			<div class="row">
			<div class="col-md-12 mb-3">
					<label>New Password</label> <input class="form-control" name="newpassword" value="newpassword"
						type="password" />
				</div>
				<div class="col-md-12 mb-3">
					<label>Verify Password</label> <input class="form-control" name="verifypassword" value="verifypassword"
						type="password" />
				</div>
				<button class="btn btn-primary" type="submit" value="resetPassword" name="resetPassword">Submit</button>
			</div>
		</form>
	</div>


	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

</body>
</html>