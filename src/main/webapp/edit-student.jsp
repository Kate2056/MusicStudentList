<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Student</title>
</head>
<body>
<h1>Edit Student:</h1>
<form action ="editStudentServlet" method="post">
Name: <input type ="text" name ="name" value="${studentToEdit.name}">
<br>
<br>
Instrument: <input type ="text" name ="instrument" value="${studentToEdit.instrument}">
<input type ="hidden" name ="id" value="${studentToEdit.id}">
<br>
<br>
<input type ="submit" value="Save Edited Student">
</form>
</body>
</html>