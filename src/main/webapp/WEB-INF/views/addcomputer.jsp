<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<title>Computer Registration</title>
</head>
<body>

<h1>Computer Registration submits get request</h1>

<form method="get" action="/processaddcomputer">

<div>

<label>Name</label>
<input type="text"  name="name">

</div>

<div>
<label>Disc size</label>
<input type="number"  name="discsize">

</div>

<input type="submit" value="Create Computer">

</form>

</body>
</html>