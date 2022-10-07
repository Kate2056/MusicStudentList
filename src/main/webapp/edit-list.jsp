<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit An Existing List of Students</title>
</head>
<body>
<h1>Edit An Existing List of Students:</h1>
<form action ="editListDetailsServlet" method="post">
<input type ="hidden" name ="id" value=" ${listToEdit.id}">
List Name: <input type ="text" name ="listName" value="${listToEdit.listName}"><br />
Music Teacher Name: <input type ="text" name ="musicTeacherName" value="${listToEdit.musicTeacher.musicTeacherName}"><br />
All Students:<br /><select name="allStudentsToAdd" multiple size="6">
<c:forEach items="${requestScope.allStudents}" var="currentstudent">
<option value ="${currentstudent.id}">${currentstudent.name} | ${currentstudent.instrument}</option>
</c:forEach>
</select>
<br />
<input type ="submit" value="Edit List and Add Students">
</form>
<a href ="index.html">Go add new students instead.</a>
</body>
</html>