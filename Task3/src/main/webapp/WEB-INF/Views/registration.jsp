<%@page import="com.codsoft.pojo.UserInfo"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Event Registration</title>
    <link rel="stylesheet" href="css/reg.css">
</head>
<body>
<%
UserInfo user = (UserInfo) request.getAttribute("user");
        if (user == null) {
            user = new UserInfo(); // avoid null pointer
        }
        request.setAttribute("userObj", user); // for EL expressions
        String msg = (String) request.getAttribute("msg");
    %>
    <div class="container">
    <img alt="Login Graphic" src="images/ShopingImage.png">
        <form class="registration-form" action="adduser" method="post">
            <h2>Customer Registration</h2>
            <p>Register with us to get more details.</p>

            <div class="input-group">
                <label>Name</label>
                <div class="name-fields">
                    <input type="text" name="cName" value="${userObj.cName}" placeholder="Full Name" required>
                </div>
            </div>
            <div class="input-group">
                <label>Email</label>
                <div class="name-fields">
                    <input type="email" name="email" value="${userObj.email}" placeholder="Email id" required>
                </div>
            </div>
            <div class="input-group">
                <label>Uername</label>
                <input type="text" name="username" value="${userObj.username}" placeholder="Username" required>
            </div>
            <div class="input-group">
                <label>Password</label>
                <input type="password" name="password" value="${userObj.password}"  placeholder="Password" required>
            </div>
			<div class="input-group">
                <label>OTP</label>
                <input type="text" name="otp" placeholder="Ensert your Otp">
            </div>
			<button type="submit" class="submit-btn" value="sendOtp" name="b1">Send OTP</button>
			<hr>
            <button type="submit" class="submit-btn" value="signUp" name="b1">Sign me up</button>
        </form>
    </div>
</body>
</html>
