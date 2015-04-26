<html>
<body>
	<h1>${headerMessage}</h1>
 
	<h3>Congratulations!! Thanks for registering with Bookface!!</h3>

	<h2>Details submitted by you:: </h2>

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
