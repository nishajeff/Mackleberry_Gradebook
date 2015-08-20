<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get Average Grade</title>
</head>
<body>
${message}<br>
<p>To enter another grade, click on the Back
button in your browser or the Return button shown
below.</p>
<form action="index.html">
<input type="submit" value="Return">
</form>
<p>To get the average grade, click on  the Get Average  button shown
below.</p>
<form action="GetAverage" method="get">
<input type="submit" value="GetAverage">
</form>
</body>
</html>