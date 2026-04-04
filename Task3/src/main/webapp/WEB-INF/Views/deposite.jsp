<%@page import="com.codsoft.pojo.Account"%>
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
Double amt = (Double) request.getAttribute("curamt");
if (amt != null) {
    out.print(amt + " new acc bal \n");
}
String msg = (String)request.getAttribute("msg");
if(msg!=null)
	out.print(msg);

Account a = (Account)request.getAttribute("account");
if(a!=null)
{
%>
</h1>
<br>
<h3>Deposit Account</h3>
<br>
<form action="accaction" method="post">
Acc-Number: <input type="text" name="accno" value="<%=a.getAccno()%>" readonly="readonly"><br><br>
Cust-Name : <input type="text" name="custname" value="<%=a.getCustname()%>" readonly="readonly"><br><br>
Acc-Type : <input type="text" name="type" value="<%=a.getType()%>" readonly="readonly"><br><br>
Balance : <input type="text" name="bal" value="<%=a.getBal()%>" readonly="readonly"><br><br>
Amount : <input type="text" name="amt">
<input type="submit" value="deposite" name="b1">
<br>
<br>
<a href="home">Back TO Account Home</a><br><br>
<br>
</form>
<%
}
%>
<%@include file="footer.jsp" %>
</body>
</html>