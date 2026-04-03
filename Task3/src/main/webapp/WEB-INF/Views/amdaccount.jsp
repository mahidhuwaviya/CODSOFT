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
%>
</h1>
<br>
<h3>Add / Update / Delete Account</h3>
<br>
<form action="saveaccount" method="post">
Acc-Number: <input type="text" name="accno"><br><br>
Cust-Name : <input type="text" name="custname"><br><br>
Acc-Type : <input type="text" name="type"><br><br>
Balance : <input type="text" name="bal"><br><br>
<input type="submit" value="Open Acc" name="b1">
<input type="submit" value="Update Acc" name="b1">
<input type="submit" value="Close Acc" name="b1">
<a href="home">Back TO Account Home</a><br><br>
<br>
</form>
<%@include file="footer.jsp" %>
</body>
</html>