<html>
<body>
<%@include file="header.jsp" %>
<h2>Registration Page</h2>
<%
String msg = (String)request.getAttribute("msg");
if(msg!=null)
	out.print(msg);
%>
<!-- <form action="addNewUser" method="post" enctype="multipart/form-data">
 -->
<form action="addNewUser" method="post" >
Username<input type="text" name="username"><br><br>
Password<input type="password" name="password"><br><br>


<!-- Upload DP :<input type="file" name="dp" accept="images/**"><br><br> -->

<!-- <label>OTP</label> <input type="text" name="otp" placeholder="Ensert your Otp">
    
			<button type="submit" value="sendOtp" name="b1">Send OTP</button>
			 -->
			<hr>
			<br>
			<br>
            <button type="submit" class="submit-btn" value="signUp" name="b1">Sign me up</button>
       
</form>
<%@include file="footer.jsp" %>
</body>
</html>
