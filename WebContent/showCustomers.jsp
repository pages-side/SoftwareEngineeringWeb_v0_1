<%@ page import="com.beans.CustomerBean" %>
<%@ page import="com.business.*" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer List</title>
</head>
<body>
 
<%   
	CustomerBean result = (CustomerBean)session.getAttribute("result");
	ArrayList<Customer>customerList = result.getCustomerList();
	for(int ii=0; ii<customerList.size(); ii++){
 %>
 	<p><%=customerList.get(ii).toString() %></p>
 <%} %>
</body>
</html>