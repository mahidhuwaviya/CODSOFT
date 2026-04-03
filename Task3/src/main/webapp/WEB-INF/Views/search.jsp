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
<br>
<form action="accoperation" method="post">
<h1>
Select Account No :
</h1>

<br>
<select name="s1">

<%
List<Account>lst = (List<Account>)request.getAttribute("allacc");
if(lst.size()>0)
{
	for(int i=0; i<lst.size(); i++)
	{
		Account a = lst.get(i);
		%>
		<option value="<%=a.getAccno()%>"><%=a.getAccno()%></option>
		<%
	}
}
%>

</select>
<br>
<br>
<input type="submit" value="Withdraw" name="action">
<input type="submit" value="Deposit" name="action">
<br>
<br>
<a href="home">Back To Account Home Page</a><br><br>
<br>
</form>
<%@include file="footer.jsp" %>
</body>
</html>