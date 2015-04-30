<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<body>
	<h1>${headerMessage}</h1>
	<h3> Registration Form</h3>

	<form:errors path="user1.*"/>
	
	<form action="/bookface/submitRegister.html" method="post">
		<table>
		<tr><td>User Name :   		</td>  <td>       <input type="text" name="userName" />   </td> </tr>
		<tr><td>User Hobby :  		</td>  <td>       <input type="text" name="userHobby" />  </td> </tr>
		<tr><td>User Mobile : 		</td>  <td>       <input type="text" name="userMobile" /> </td> </tr>
		<tr><td>User DOB :    		</td>  <td>       <input type="text" name="userDOB" />    </td> </tr>
		
		<tr><td>Book List :	</td>  <td>    			<select name="bookList" multiple>
																<option value="Outliers">Outliers</option>
																<option value="Flabbergusted">Flabbergusted</option>
																<option value="D-Day">D-Day</option>
																</select><td></tr>
	</table>
	<table>
			<tr><td>User Address : </td></tr> 
		<tr>
			<td>country: <input type="text" name="userAddress.country"/></td>
			<td>city: <input type="text" name="userAddress.city" /></td>
			<td>street: <input type="text" name="userAddress.street" /></td> 
			<td>pincode:<input type="text" name="userAddress.pincode" /></td>
		</tr>
		
		<tr><td><input type="submit" value="Submit this form by clicking here" /></td></tr>
	</table>
		
	</form>
 
</body>
</html>

