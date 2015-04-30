<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<h1>${headerMessage}</h1>
<h2>List of Books, Authors, Comments</h1>	
<table>
  <c:forEach items="${bookList}" var="item">
    <tr>
      <td><c:out value="${item}" /></td>
    </tr>
  </c:forEach>
</table>

<h3>List of Users</h1>	
<table>
  <c:forEach items="${userList}" var="item">
    <tr>
      <td><c:out value="${item}" /></td>
    </tr>
  </c:forEach>
</table>
<form action="/bookface/Register.html" method="get">
		<tr><td><input type="submit" value="Register" /></td></tr>
</form>
</body>
</html>
