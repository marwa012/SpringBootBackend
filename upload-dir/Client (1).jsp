<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>CLIENTS</h1>

<form method = "post" action="Session" >
<p>UserName: <input type="text" name="user"></p>
<p>Password : <input type="password" name="pass" ></p>
<input type="submit" value="Connect">

</form>
${user }
${msg }
</body>
</html>