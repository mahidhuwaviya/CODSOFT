<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="header.jsp" %>
<h1>
<%
String msg = (String)request.getAttribute("msg");
if(msg!=null)
	out.print(msg);

String dp = (String)request.getAttribute("dp");


%>
</h1>
<img alt="" src="dp/<%=dp%>" height="50" width="30">
<br>
<a href="amdaccount">Add / Update /Delete Account</a><br><br>
<a href="listofaccounts">List Of All Accounts</a><br><br>
<a href="search">Search Account</a><br><br>
<a href="logout">Logout</a><br><br>
<br>
<%@include file="footer.jsp" %>
</body>
</html>