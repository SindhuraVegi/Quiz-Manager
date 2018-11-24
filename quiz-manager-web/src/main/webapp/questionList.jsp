<%@page import="fr.epita.quiz.datamodel.Questions"%>
<%@page import="fr.epita.quiz.services.GenericORMDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	List<Questions> questionsList = (List<Questions>)session.getAttribute("questionsList");
   session.removeAttribute("questionsList");
%>
<head>
<%
	Boolean auth = (Boolean) session.getAttribute("authenticated");
	if (auth == null || !auth) {
%>
<meta http-equiv="refresh" content="0; URL=index.html">
<%
	}
%>

<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="resources/css/custom-styles.css" />
</head>
<body>
   <div class="container">
		<div>
			<div class="jumbotron">
				<div class="container">
					<h1 class="text-info" align="center">List of all Questions</h1>
					
				</div>
				
							<div align="left"><a href="<%=request.getContextPath()%>/usersService">List of Users</a></div>
				<div align="right">
				<a href="selectQuestionType.jsp">Question Type</a>
			</div>
								<div>	<a href="question.jsp">Create New Question</a></div>
				<div align="right">
				<a href="adminLogin.html">Logout</a>
			</div>
			</div>

	</div>
	<div class="container">
		<h3 class="text-info">Search Results</h3>

		<form class="form-horizontal"  method="post" action="modifyQuestion">
			<div class="table-responsive">
				<table class="table">
					<thead>
						<tr>
							<th>ID</th>
							<th>Quiz Name</th>
							<th>Question</th>
							<th>Answer1</th>
							<th>Answer2</th>
							<th>Answer3</th>
							<th>Answer4</th>
							<th>Correctanswer</th>
							<th>QuestionType</th>
						</tr>
					</thead>
					<tbody>
					   <%
					   	if (questionsList == null || questionsList.isEmpty()){
					   %>
						  <tr>
						      <td colspan="7">No result</td>
						  </tr>
						   
					   <%
						   					   	} else{
						   					   				   					   			   for (Questions id : questionsList){
						   					   %>
						<tr>
							<td><input name="selection" type="radio" value="<%=id.getId()%>"/></td>
        					<td><%=id.getQuizName() %></td>
  							<td><%=id.getQuestion() %></td>
							<td><%=id.getAnswer1() %></td> 
							<td><%=id.getAnswer2() %></td>
							<td><%=id.getAnswer3() %></td>
							<td><%=id.getAnswer4() %></td>
							<td><%=id.getCorrectanswer() %></td>
							<td><%=id.getType() %></td>
						</tr>
                        <%} 
                        }%>

					</tbody>
				</table>
			</div>
			<div class="form-group" align="center">
				<div class=" col-sm-offset-2 col-sm-10 text-right">
					
					<button type="submit" style="margin-right: 30px" class="btn btn-primary" value="Modify" name="modify">Modify</button>
					<button type="submit" style="margin-right: 30px"class="btn btn-danger" value="Delete" name="delete">Delete</button>
					<button type="submit" style="margin-right: 30px"class="btn btn-danger" value="DeleteAll" name="deleteAll">Delete All</button>
				</div>
	</div>
	</form>
	</div>
</div>
</body>
</html>
