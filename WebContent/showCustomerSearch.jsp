<%@ page import="com.beans.CustomerBean" %>
<%@ page import="com.business.*" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Search Results:</title>
</head>
<body>
	<h2>Customer Search Results:</h2> 
		<table>
			<tbody>
			
<%   
	CustomerBean result = (CustomerBean)session.getAttribute("result");
	ArrayList<Customer>customerList = result.getCustomerList();
	for(int ii=0; ii<customerList.size(); ii++){
		Customer c = customerList.get(ii);
 %>		

				<tr>
					<td>Customer Number:</td>
					<td><%=c.getCno() %></td>
					<td>Customer Name:</td>
					<td><%=c.getCname() %></td>
				</tr>
				<tr>
					<td>Street:</td>
					<td><%=c.getStreet() %></td>
					<td>City:</td>
					<td><%=c.getCity() %></td>
				</tr>
				<tr>
					<td>Zip Code:</td>
					<td><%=c.getZip() %></td>
					<td>Phone:</td>
					<td><%=c.getPhone() %></td>
				</tr>
				<tr>
					<td>Member Status:</td>
					<td><%=c.getMemberStatus() %>></td>
				</tr>
			</tbody>
		</table>
 <%} %>
</body>
</html>