<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Question Edition</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/custom-styles.css">
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<div class="container">
				<h1 class="text-info" align="center">MCQ Questions</h1>
			</div>
		<div>	<a href="<%=request.getContextPath() %>/questionList">List of
					Questions</a></div>
			<div align="right">
				<a href="selectQuestionType.jsp">Question Type</a>
			</div>
			<div align="left"><a href="<%=request.getContextPath() %>/usersService">List of Users</a></div>
<div align="right">
				<a href="adminLogin.html">Logout</a>
			</div>
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
			<fieldset class="form-group">
				<div class="row">
					<legend class="col-form-label col-sm-2 pt-0">Answers</legend>
					<div class="col-sm-10 answers-cont">
						<div class="form-check">
							<input class="form-control" type="text" name="Answer1"
								id="answer1" placeholder="first answer">

						</div>
						<div class="form-check">
							<input class="form-control" type="text" name="answer2"
								id="answer2" placeholder="second answer">
						</div>
						<div class="form-check">
							<input class="form-control" type="text" name="answer3"
								id="answer3" placeholder="third answer">
						</div>
						<div class="form-check">
							<input class="form-control" type="text" name="answer4"
								id="answer4" placeholder="fourth answer">
						</div>
					</div>
			</fieldset>

			<div class="form-group row">
				<label for="Correctanswer" class="col-sm-2 col-form-label">Correct
					Answer</label>
				<div class="col-sm-10">
					<select class="form-control" id="answer" name="answer">
						<option>Please Select An Answer</option>
						<option value="answer1">Answer 1</option>
						<option value="answer2">Answer 2</option>
						<option value="answer3">Answer 3</option>
						<option value="answer4">Answer 4</option>
					</select>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-10" align="center">
					<button type="submit" name="mcq" value="mcq" class="btn btn-primary">Validate</button>
				</div>
			</div>
	</div>


	</form>
	</div>

</body>
</html>