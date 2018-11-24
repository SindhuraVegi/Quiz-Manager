<%@page import="fr.epita.quiz.datamodel.Users"%>
<%@page import="fr.epita.quiz.services.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="resources/css/custom-styles.css">
</head><div class="container" align="center">
  <h2>Select Question Type</h2>
  
         <div class="form-group ">
      <label class="control-label " for="select">
       Select a Choice
      </label>
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
      <!-- <select class="select form-control" id="select" name="select">
       <option value="First Choice">
        Python
       </option>
       <option value="Second Choice">
        Angular Quiz
       </option>
       <option value="Third Choice">
        JAVA QUIZ
       </option>
      </select> -->
     </div>

      <input type="button" class="btn btn-primary" style="margin:10px;" onclick="location.href='question.jsp';" value="MCQ Question" />
      <input type="button" class="btn btn-primary" style="margin:10px;" onclick="location.href='openQuestion.jsp';" value="The Open Questions" />   
</div>
</html>