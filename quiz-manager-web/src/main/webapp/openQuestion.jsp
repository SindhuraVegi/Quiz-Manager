<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Question Edition</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<div class="container">
				<h1 class="text-info" align="center">Add New Question</h1>
			</div>
		<div>	<a href="<%=request.getContextPath() %>/questionList">List of
					Questions</a></div>
			<div align="right">
				<a href="adminLogin.html">Logout</a>
			</div>
			<div align="left"><a href="<%=request.getContextPath() %>/usersService">List of Users</a></div>

		</div>
		<form action="questionAction" method="post">
			<div class="form-group row">
				<label for="quizName" class="col-sm-2 col-form-label">Quiz
					Name</label>
				<div class="col-sm-10">
					<textarea type="text" class="form-control" id="quizName"
						name="quizName"
						placeholder="Please provide the name of Quiz under this question will populate"></textarea>
				</div>
			</div>
			<div class="form-group row">
				<label for="question" class="col-sm-2 col-form-label">Question
					Title</label>
				<div class="col-sm-10">
					<textarea type="text" class="form-control" id="question"
						name="question" placeholder="Your question here"></textarea>
				</div>
			</div>

			<div class="form-group row">
				<div class="col-sm-10" align="center">
					<button type="submit"  name="open" value="open"class="btn btn-primary">Validate</button>
				</div>
			</div>
	</div>


	</form>
	</div>

</body>
</html>