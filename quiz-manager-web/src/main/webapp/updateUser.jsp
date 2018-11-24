<%@page import="fr.epita.quiz.datamodel.Users"%>
<%@page import="fr.epita.quiz.services.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
 Users user = (Users) session.getAttribute("Users");
%>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
  <script>
$('select').on('change', function(){
	alert(this.value);
})
</script>	
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
					   if (user == null){%>
<tr>
	<td colspan="4">No result</td>
</tr>

<% } else{
					    %>
<body>
	<div class="container">
		<div>
			<div class="jumbotron">
				<div class="container">
					<h1 align="center" class="text-info">Update User</h1>
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
		</div>
		<form role="form" method="post" action="modifyUser">
			<div class="form-group row">
				 <input name="id"
					value="<%=user.getUserRoleId()%>" type="hidden" class="form-control"
					id="id" name="id" readonly="readonly" />
			</div>
			<div class="form-group row">
				<label for="user_name" class="col-sm-2 col-form-label">User_name
					</label> <input name="user_name" value="<%=user.getUser_name()%>"
					type="text" class="form-control" id="user_name"
					placeholder="Enter unique user_name" />
			</div>
			<div class="form-group row">
				<label for="Mail" class="col-sm-2 col-form-label">mail</label>
				<input name="mail" value="<%=user.getMail()%>" type="mail"
					class="form-control" id="email" placeholder="Enter your mail" />
			</div>
		
			<div class="form-group row">
				<label for="psswd" class="col-sm-2 col-form-label">Password</label>
				<input name="psswd" value="<%=user.getPsswd()%>" type="password"
					class="form-control" id="password" placeholder="Enter your Password" />
			</div>
		
                

 <div class="form-group row">
                    <label for="role">Role</label>
                    <select  class="form-control" name="role" disabled>
                      <option selected value="<%=user.getRole()%>"><%=user.getRole()%></option>
                    </select> 
                    
                                    
                </div>
		<input  value="<%=user.getRole()%>" id="mytext"  type="hidden"
					class="form-control" id="role" name="role"/>  
			<button type="submit" style="margin-center: 30px" class="btn btn-primary" value="Update"
				name="update">Update</button>

		</form>
	</div>

</body>



<%} 
                        %>


</html>
