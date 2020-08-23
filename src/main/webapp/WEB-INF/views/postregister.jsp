<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<title>Supplier Registration</title>
</head>
<body>

<h1>Supplier Registration submits post request</h1>

<form:form method="post" action="/processpostregister" modelAttribute="supplier">

<div>


<label>Name</label>
<form:input path="name"/>

</div>


<div>
<label>Password</label>
<form:input path="password"/>

</div>



<input type="submit" value="Create Supplier">

</form:form>

</body>
</html>