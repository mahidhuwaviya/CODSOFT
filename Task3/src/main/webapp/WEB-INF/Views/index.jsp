<html>
<body>
<%@include file="header.jsp" %>
<h2>Login Page</h2>
<%
String msg = (String)request.getAttribute("msg");
if(msg!=null)
	out.print(msg);
%>
<form action="checkUser" method="post" >
Username<input type="text" name="username"><br><br>
Password<input type="password" name="password"><br><br>
<input type="submit" value="Login Here">
<a href="reg">New User Registration</a>
</form>
<%@include file="footer.jsp" %>
</body>
</html>
