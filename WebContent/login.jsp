<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sharky's Gameroom</title>
</head>
<body>
	<form action="Controller" method="post">
		
		<input type="hidden" name="requester" value="login" /> <input
			type="hidden" name="mode" value="search" />
		<table style="position: absolute; top: 0; bottom: 0; left: 0; right: 0;" bgcolor="#008B8B" height="100%" width="100%">
			<tbody>
				<tr style="height:50%;text-align:center; font-size:80px; color:#FFFFFF;">
				<td>Welcome to Sharky's</td>
				<td bgColor="#008B8B"  style="font-size:20px; text-align:bottom">
						<table >
							<tr>
								<td>UserName:</td>
								<td><input type="text" name="username" /></td>
							</tr>

							<tr>
								<td>Password:</td>
								<td><input type="text" name="password" /></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td style="width:100%; float:right;"><input type="submit" />
							</tr>
						</table>
					</td>
				
				</tr>
				<tr style="height:50%">
					<td width="50%" bgcolor="#008B8B">
						<table>
							<tr>
								<td style="text-align:right;">
									<img  style="padding-left:10px; height:80%; width:80%;"src="images/uncw.jpg"/>
								</td>
							</tr>
							
							<tr>
							
							</tr>
						</table>
					</td>
									</tr>
			</tbody>
		</table>
		
	</form>
</body>
</html>