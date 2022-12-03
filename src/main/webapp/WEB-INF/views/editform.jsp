<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page import="com.example.board.dao.BoardDAO, com.example.board.bean.BoardVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Form</title>
</head>
<body>

<%--<%--%>
<%--	BoardDAO boardDAO = new BoardDAO();--%>
<%--	String id=request.getParameter("id");	--%>
<%--	BoardVO u=boardDAO.getBoard(Integer.parseInt(id));--%>
<%--%>--%>

<h1>Edit Form</h1>
<form:form modelAttribute="boardVO" method="post" action="../editok">
	<form:hidden path="seq"/>
	<table id="edit">
		<tr><td>Title:</td><td><form:input path="title" /></td></tr>
		<tr><td>Writer:</td><td><form:input path="writer" /></td></tr>
		<tr><td>Content:</td><td><form:input path="content" /></td></tr>
	</table>
	<button type="submit">Edit</button>
	<input type="button" value="Cancel" onclick="history.back()"/>
</form:form>


</body>
</html>