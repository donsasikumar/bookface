<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Verify Users</title>
</head>
<body>

<table>
  <c:forEach items="${bookList}" var="item">
    <tr>
      <td><c:out value="${item}" /></td>
    </tr>
  </c:forEach>
</table>
	<h1>${headerMessage}</h1>
	
	<h2>${bookList}</h2>

	<table>
		<tr>
			<td>User Name :</td>
			<td>${user1.userName}</td>
		</tr>
		<tr>
			<td>User Hobby :</td>
			<td>${user1.userHobby}</td>
		</tr>
		<tr>
			<td>User Mobile :</td>
			<td>${user1.userMobile}</td>
		</tr>

		<tr>
			<td>User DOB :</td>
			<td>${user1.userDOB}</td>
		</tr>
		<tr>
			<td>User Skills :</td>
			<td>${user1.userSkills}</td>
		</tr>
		<tr>
			<td>User Address :</td>
			<td>country: ${user1.userAddress.country}
			       city: ${user1.userAddress.city}
			     street: ${user1.userAddress.street}
			    pincode: ${user1.userAddress.pincode}</td>
		</tr>

	</table>

</body>
</html>
