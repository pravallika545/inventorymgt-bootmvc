<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<title>Details</title>
</head>
<body>

<h1>Phone Details </h1>

id is <c:out value="${phone.id}"  />
<br>
name is <c:out value="${phone.name}"  />
<br>
storage size is <c:out value="${phone.storagesize}"  />

<br>
</body>
</html>