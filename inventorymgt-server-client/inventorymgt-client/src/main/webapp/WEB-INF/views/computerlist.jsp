<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<title>All Computers</title>
</head>
<body>

<h1>Listing all Computer</h1>


<c:forEach items="${computers}"  var="computer">

id is <c:out value="${computer.id}"  />
<br>

name is <c:out value="${computer.name}"  />
<br>
disc size is <c:out value="${computer.discsize}"  />

<br>
</c:forEach>

</body>
</html>