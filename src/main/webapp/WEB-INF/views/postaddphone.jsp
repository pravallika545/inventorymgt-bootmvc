<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<title>Phone Registration</title>
</head>
<body>

<h1>Phone Registration submits post request</h1>

<form:form method="post" action="/processpostadd" modelAttribute="phone">

<div>


<label>Name</label>
<form:input path="name"/>

</div>


<div>
<label>Storage size</label>
<form:input path="storagesize"/>

</div>



<input type="submit" value="Create Phone">

</form:form>

</body>
</html>