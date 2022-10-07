<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create a new list</title>
</head>
<body>
<form action ="createNewListServlet" method="post">
List Name: <input type ="text" name ="listName"><br /> 
Music Teacher Name: <input type ="text" name ="musicTeacherName"><br />
Current Students:<br />
<select name="allStudentsToAdd" multiple size="6">
<c:forEach items="${requestScope.allStudents}" var="currentstudent">
<option value ="${currentstudent.id}">${currentstudent.name} | ${currentstudent.instrument}</option>
</c:forEach>
</select>
<br />
<input type ="submit" value="Create A List and Add Music Students">
</form>
<br>
<a href ="index.html">Click here to add more students</a>
</body>
</html>