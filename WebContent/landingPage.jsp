<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style media="screen" type="text/css">
Add
 
style
 
rules
 
here
</style>
<title>Sharky's Gameroom</title>
</head>
<body>
	<form action="Controller" method="post">

		<input type="hidden" id="requester" name="requester" value="login" />
		<input type="hidden" name="mode" value="search" />
		<table
			style="position: absolute; top: 0; bottom: 0; left: 0; right: 0;"
			bgcolor="#008B8B" height="100%" width="100%">
			<tbody>
				<tr
					style="height: 10%; width: 40%; text-align: left; font-size: 12px; color: #FFFFFF;">
					<td>
						<table>
							<tr>
							<td>Welcome to Sharky's:<%=request.getSession().getAttribute("USER")%></td>
							<td>Menu1</td>
							<td>Menu2</td>
							<td>Menu3</td>
							<td>Menu4</td>
							</tr>
						</table>
					</td>
				<tr style="height: 80%; text-align: center; font-size: 16px;">
					<td style="width: 50%;">&nbsp;</td>
					<td style="bg-color: #FFFFFF; vertical-align:top;" >
						<table style=" border: 1px solid black; margin-bottom:50px;" border=1 bgcolor="#FFFFFF">
							<tr>
								<td colspan="3" height="10%" style="font-weight:bold; font-size:20px;">Currently Playing</td>
							
							</tr>
							<tr style="height: 50px; bg-color: #FFFFFF; font-weight:bold;">
								<td style="width: 15%; height:5%;">Cust No:</td>
								<td style="width: 15%; height:5%;">Customer Name</td>
								<td style="width: 15%;  height:5%;">Game</td>
							</tr>
							<tr height="50px;">
								<td style="width: 15%;height:5%;">85012324</td>
								<td style="width: 15%; height:5%;">Amanda Whatsername</td>
								<td style="width: 15%; height:5%;"><select name="currentgame">
										<option value="pool1">Pool (1)</option>
										<option value="pool2">Pool (2)</option>
										<option value="pool3">Pool (3)</option>
										<option value="pingpong">Ping Pong</option>
										<option value="xbox">X Box</option>
										<option value="wii">Wii</option>
								</select>
							</tr>
							</table>
							<table style="width:100%; border: 1px solid black" border=1 bgcolor="#FFFFFF">
							<tr>
								<td colspan="3" height="10%">Add a Customer</td>
							
							</tr>
							<tr style="height: 10%; bg-color: #FFFFFF">
								<td style="width: 15%;height:5%;">Cust No: <br/><input type="text" name="customerNo">
								</td>
								<td style="width: 15%;height:5%;">Customer Name: <br/><input type="text"	name="customerNo"></td>
								<td style="width: 15%;height:5%;">Game:<br/><select name="customergameadd">
										<option value="pool1">Pool (1)</option>
										<option value="pool2">Pool (2)</option>
										<option value="pool3">Pool (3)</option>
										<option value="pingpong">Ping Pong</option>
										<option value="xbox">X Box</option>
										<option value="wii">Wii</option>
								</select>
								</td>
							</tr>
							<tr>
								<td colspan="3" style="height:5%;"><input type="button" value="Add"
									onclick="document.getElementById('requester').value='add'; form.submit();" /></td>
							</tr>
						</table>
					</td>
				</tr>
			</tbody>
		</table>

	</form>
</body>
</html>