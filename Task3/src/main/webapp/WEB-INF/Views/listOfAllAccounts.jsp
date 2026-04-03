<%@page import="com.codsoft.pojo.Account"%>
<%@page import="java.util.List"%>
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

<table border="2"/>
<tr>
	<th>S.No</th>
	<th>Account No</th>
	<th>Cust-name</th>
	<th>Account-Type</th>
	<th>Balance</th>
</tr>
<%
List<Account>lst=(List<Account>)request.getAttribute("allacc");
if(lst.size()>0){
	for(int i=0; i<lst.size();i++){
		
		Account a= lst.get(i);
		%>
		<tr>
			<td><%=i+1 %></td>
			<td><%=a.getAccno() %></td>
			<td><%= a.getCustname() %></td>
			<td><%=a.getType() %></td>
			<td><%=a.getBal() %></td>
		</tr>
	<%
		
	}
}
%>
<a href="logout">Logout</a>
<br><br>
<br>
<%@include file="footer.jsp" %>
</body>
</html>