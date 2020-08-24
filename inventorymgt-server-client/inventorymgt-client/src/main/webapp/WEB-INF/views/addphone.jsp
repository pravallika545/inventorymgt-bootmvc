<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<title>Phone Registration</title>
</head>
<body>

<h1>Phone Registration submits get request</h1>

<form method="get" action="/processaddphone">

<div>

<label>Name</label>
<input type="text"  name="name">

</div>

<div>
<label>Storage size</label>
<input type="number"  name="storagesize">

</div>

<input type="submit" value="Create Phone">

</form>

</body>
</html>