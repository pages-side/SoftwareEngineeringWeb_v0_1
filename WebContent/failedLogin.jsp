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
		
		<input type="hidden" name="requester" value="login" /> <input type="hidden" name="mode" value="search" />
		<table style="position: absolute; top: 0; bottom: 0; left: 0; right: 0;" bgcolor="#008B8B" height="100%" width="100%">
			<tbody>
				<tr style="height:10%;text-align:center; font-size:12px; color:#FFFFFF;">
				<td>Invalid Login <%=request.getSession().getAttribute("USER") %></td>
				</tr>
				<tr style="height:10%;text-align:center; font-size:12px; color:#FFFFFF;">
				<td><a href="login.jsp">Return</a></td>
				</tr>
			</tbody>
		</table>
		
	</form>
</body>
</html>