<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<title>Details</title>
</head>
<body>

<h1>Computer Details </h1>

id is <c:out value="${computer.id}"  />
<br>
name is <c:out value="${computer.name}"  />
<br>
disc size is <c:out value="${computer.discsize}"  />

<br>
</body>
</html>