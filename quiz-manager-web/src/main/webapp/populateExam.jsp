<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<div class="container">
				<h1 class="text-info" align="center">Question Paper</h1>
			</div>

	
			<div class="container" align="center">
				<iframe
					src="http://free.timeanddate.com/clock/i6an01ok/n195/szw110/szh110/hoc000/hbw2/hfceee/cf100/hncccc/fdi76/mqc000/mql10/mqw4/mqd98/mhc000/mhl10/mhw4/mhd98/mmc000/mml10/mmw1/mmd98"
					frameborder="0" width="110" height="110"></iframe>					
			</div>
					<div class="container" align="left">
				<b> <%
 	if (session.getAttribute("userName") != null) {
 %> Welcome : <%
 	out.print(session.getAttribute("userName"));
 %>
					<%
						}
					%>
				</b>
			</div>
			<div class="container" align="right">
				<b> <a href="logout.html">LogOut</a></b>
			</div>


		</div>

	</div>

	<div class="container">
		<form class="form-horizontal" method="post" action="examResult">
			<table class="table">
				<core:if test="${!empty ques}">
					<%
						int i = 0;
					%>

					<core:forEach var="questionPaperCommand" items="${ques}">
						<input type="hidden" name="question" />
						<input type="hidden" value="${questionPaperCommand.id}"
							name="quesNum[<%=i%>]" />
						<tr>
							<td><core:out value="<%=i + 1%>"></core:out> <core:out
									value="."></core:out> <core:out
									value="${questionPaperCommand.question}"></core:out></td>
						</tr>
						<tr>
							<td><input type="radio" name="option[<%=i%>]"
								value="${questionPaperCommand.answer1}"> <core:out
									value="${questionPaperCommand.answer1}"></core:out></td>
						</tr>
						<tr>
							<td><input type="radio" name="option[<%=i%>]"
								value="${questionPaperCommand.answer2}"> <core:out
									value="${questionPaperCommand.answer2}"></core:out></td>
						</tr>
						<tr>
							<td><input type="radio" name="option[<%=i%>]"
								value="${questionPaperCommand.answer3}"> <core:out
									value="${questionPaperCommand.answer3}"></core:out></td>
						</tr>
						<tr>
							<td><input type="radio" name="option[<%=i%>]"
								value="${questionPaperCommand.answer4}"> <core:out
									value="${questionPaperCommand.answer4}"></core:out></td>
						</tr>
						<%
							i++;
						%>
					</core:forEach>

					<tr>
						<td><input type="submit" value="Submit" /></td>
					</tr>
				</core:if>
				<core:if test="${empty questionPaperList}">
					<tr>
						<td><core:out value="Finished!!"></core:out>
						</td>
					</tr>
				</core:if>
			</table>
		</form>
	</div>
</body>
</html>