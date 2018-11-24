<%@page import="fr.epita.quiz.datamodel.Questions"%>
<%@page import="fr.epita.quiz.services.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	Questions addQuestion = (Questions) session.getAttribute("addQuestion");
%>
<head>
<%
	Boolean auth = (Boolean) session.getAttribute("authenticated");
	if (auth == null || !auth) {
%>

<meta http-equiv="refresh" content="0; URL=index.jsp">
<%
    }
%>

<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>

					   <%
					   if (addQuestion == null){%>
						  <tr>
						      <td colspan="4">No result</td>
						  </tr>
						   
					   <% } else{
					    %>	
<body>
		<div class="container">
		<div>
			<div class="jumbotron" align="center">
				<div class="container">
					<h1 class="text-info">Update Open Question</h1>
				</div>
								<div align="left"><a href="<%=request.getContextPath() %>/usersService">List of Users</a></div>
				<div align="right">
				<a href="selectQuestionType.jsp">Question Type</a>
			</div>
								<div align="left">	<a href="question.jsp">Add New Question</a></div>
				<div align="right">
				<a href="adminLogin.html">Logout</a>
			</div>
			<div align="left">	<a href="<%=request.getContextPath() %>/questionList">List of
					Questions</a></div>		
			</div>	
		
				</div>
			<form role="form" method="post" action="modifyQuestion">
			   <div class="form-group row">
					<input name="id" value="<%=addQuestion.getId()%>" type="hidden" class="form-control" id="id"
						placeholder="enter  id" readonly="readonly" />
				</div>
				<div class="form-group row">
					<label for="quizName" class="col-sm-2 col-form-label">Quiz Name</label> 
					<input name="quizName" value="<%=addQuestion.getQuizName()%>" type="text" class="form-control" id="quizName"
						placeholder="Enter your Quiz Name" />
				</div>
				<div class="form-group row">
					<label for="question" class="col-sm-2 col-form-label">Question Title</label> 
					<input name="question" value="<%=addQuestion.getQuestion()%>" type="text" class="form-control" id="question"
						placeholder="Enter your Question" />
				</div>	
					<button type="submit" class="btn btn-primary" value="UpdateOpen" name="updateOpen">Update</button>

			</form>
		</div>
	
</body>
							
							
						
                        <%} 
                        %>
                       

</html>
