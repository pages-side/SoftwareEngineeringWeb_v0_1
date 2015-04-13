<%@ page import="com.beans.CompanyBean" %>
<%@ page import="com.business.*" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Yay! Totally worked!</title>
</head>
<body>
 
<%   
	CompanyBean result = (CompanyBean)session.getAttribute("result");
	ArrayList<Company>companyList = result.getCompanyList();
	for(int ii=0; ii<companyList.size(); ii++){
 %>
 	<p><%=companyList.get(ii).toString() %></p>
 <%} %>
</body>
</html>