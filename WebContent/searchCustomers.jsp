<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Customers</title>
</head>
<body>
	<form action="Controller" method="post">
		<h2>Customer Search</h2>
		<input type="hidden" name="requester" value="searchCustomer" />
		<input type="hidden" name="mode" value="search" />
		<table>
			<tbody>
				<tr>
					<td>Customer Number:</td>
					<td><input type="text" name="cno" /></td>
					<td>Customer Name:</td>
					<td><input type="text" name="cname" /></td>
				</tr>
				<tr>
					<td>Street:</td>
					<td><input type="text" name="street" /></td>
					<td>City:</td>
					<td><input type="text" name="city" /></td>
				</tr>
				<tr>
					<td>Zip Code:</td>
					<td><input type="text" name="zip" /></td>
					<td>Phone:</td>
					<td><input type="text" name="phone" /></td>
				</tr>
				<tr>
					<td>Member Status:</td>
					<td><select name="status">
							<option value="">Select a Status</option>
							<option value="TRUE">Member</option>
							<option value="FALSE">Non-Member</option>
					</select></td>
				</tr>
			</tbody>
		</table>
		<input type="submit" />
	</form>
</body>
</html>