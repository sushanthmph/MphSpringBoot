<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login success</title>
</head>
<body>
<h1>Login Success....</h1>
<p>
UserName : ${data.getUsername()}<br>
Password : ${data.getPassword()}

</p>
</body>
</html>