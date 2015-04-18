<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.beans.LandingPageBean"%>
<%@ page import="com.business.*"%>
<%@ page import="java.util.*"%>
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
<title>Sharky's Game Room</title>
</head>
<body>
	<form action="Controller" method="post">

		<input type="hidden" id="requester" name="requester" value="login" />
		<input type="hidden" name="mode" value="" />
		<input type="hidden" name="cno" id="cno" value="" />
		<input type="hidden" name="game" id="game" value="" />
		<input type="hidden" name="cname" id="cname" value="" />
		<table
			style="position: absolute; top: 0; bottom: 0; left: 0; right: 0;"
			bgcolor="#008B8B" height="100%" width="100%">
			<tbody>
				<tr
					style="height: 10%; width: 40%; text-align: left; font-size: 12px; color: #FFFFFF;">
					<td>
						<table>
							<tr>
								<td>Logged in as <%=request.getSession().getAttribute("USER")%></td>
								<td>Menu1</td>
								<td>Menu2</td>
								<td>Menu3</td>
								<td>Menu4</td>
							</tr>
						</table>
					</td>
				<tr style="height: 80%; text-align: center; font-size: 16px;">
					<td style="width: 50%;">&nbsp;</td>
					<td style="bg-color: #FFFFFF; vertical-align: top;">
						<table border=1
							style="border: 1px solid white; margin-bottom: 50px; background-color: #191970; color: #7FFFD4;">
							<tr>
								<td colspan="3" height="10%"
									style="font-weight: bold; font-size: 20px;">Currently
									Playing</td>

							</tr>
							<tr style="height: 50px; bg-color: #FFFFFF; font-weight: bold;">
								<td style="width: 15%; height: 5%;">Cust No:</td>
								<td style="width: 15%; height: 5%;">Customer Name</td>
								<td style="width: 15%; height: 5%;">Game</td>
							</tr>
							<%
								LandingPageBean result = (LandingPageBean) request
										.getAttribute("results");
								ArrayList<Customer> customerList = result.getCurrentCustomerList();
								for (int ii = 0; ii < customerList.size(); ii++) {
							%>
							<tr height="50px;">
								<td style="width: 15%; height: 5%;"><%=customerList.get(ii).getCno()%>
									<input type="hidden" name="cno <%=ii %>" id="cno<%=ii %>" value="<%=customerList.get(ii).getCno()%>"/>
								</td>
								<td style="width: 15%; height: 5%;"><%=customerList.get(ii).getCname()%>
									<input type="hidden" name="customername<%=ii %>" id="customername<%=ii %>" value="<%= customerList.get(ii).getCname()%>" />
								</td>
								<td style="width: 15%; height: 5%;"><select	id="currentgame<%=ii %>" name="currentgame<%=ii %>" style="vertical-align: top; margin-top: 10px;"
								onchange="var e = document.getElementById('currentgame<%=ii %>');
											document.getElementById('game').value = e.options[e.selectedIndex].value;
											document.getElementById('cname').value = document.getElementById('cnameM<%=ii %>').value; 
											document.getElementById('cno').value=document.getElementById('cno<%=ii%>').value;
											document.getElementById('requester').value = 'transer'; 
											form.submit();">
										<option
											<%if (customerList.get(ii).getCurrentGame().equals("pool1")) {%>
											selected="selected" <%}%> value="pool1">Pool (1)</option>
										<option
											<%if (customerList.get(ii).getCurrentGame().equals("pool2")) {%>
											selected="selected" <%}%> value="pool2">Pool (2)</option>
										<option
											<%if (customerList.get(ii).getCurrentGame().equals("pool3")) {%>
											selected="selected" <%}%> value="pool3">Pool (3)</option>
										<option
											<%if (customerList.get(ii).getCurrentGame().equals("pingpong")) {%>
											selected="selected" <%}%> value="pingpong">Ping Pong</option>
										<option
											<%if (customerList.get(ii).getCurrentGame().equals("xbox")) {%>
											selected="selected" <%}%> value="xbox">X Box</option>
										<option
											<%if (customerList.get(ii).getCurrentGame().equals("wii")) {%>
											selected="selected" <%}%> value="wii">Wii</option>
								</select> 
								<input name='finish-<%=ii %>' value="<%=customerList.get(ii).getCno()%>" type="image" src="images/deletebuttonsmall.png" 
								onclick="document.getElementById('cno').value=document.getElementById('cno<%=ii%>').value;document.getElementById('requester').value = 'finish'; form.submit();"/></td>
							</tr>
							<%
								}
							%>
						</table>
						<table border=1
							style="border: 1px solid white; margin-bottom: 50px; background-color: #191970; color: #7FFFD4;">
							<tr>
								<td colspan="4" height="10%"
									style="font-weight: bold; font-size: 20px;">Finished Playing</td>

							</tr>
							<tr style="height: 50px; bg-color: #FFFFFF; font-weight: bold;">
								<td style="width: 15%; height: 5%;">Cust No:</td>
								<td style="width: 15%; height: 5%;">Customer Name</td>
								<td style="width: 15%; height: 5%;">Time Started</td>
								<td style="width: 15%; height: 5%;">Time Ended</td>
							</tr>
							<%
								
								ArrayList<Customer> finishedCustomerList = result.getFinishedCustomerList();
								for (int ii = 0; ii < finishedCustomerList.size(); ii++) {
							%>
							<tr height="50px;">
								<td style="width: 15%; height: 5%;"><%=finishedCustomerList.get(ii).getCno()%>
									<input type="hidden" name="finishcno<%=ii %>" id="finishcno<%=ii %>" value=<%=finishedCustomerList.get(ii).getCno() %> />
								</td>
								<td style="width: 15%; height: 5%;"><%=finishedCustomerList.get(ii).getCname()%></td>
								<td style="width: 15%; height: 5%;"><%= finishedCustomerList.get(ii).getStartTime()%></td>
								<td style="width: 15%; height: 5%;"><%= finishedCustomerList.get(ii).getEndTime()%></td>
							</tr>
							<%
								}
							%>
						</table>
						<table
							style="width: 100%; border: 1px solid black; color: #191970;"
							border=1 bgcolor="#7FFFD4">
							<tr>
								<td colspan="3" height="10%;"
									style="font-weight: bold; font-size: 20px;">Add a Customer</td>

							</tr>
							<tr style="height: 10%; bg-color: #FFFFFF">
								<td style="width: 15%; height: 5%; font-weight: bold;">Cust
									No: <br /> <input type="text" name="customerNo">
								</td>
								<td style="width: 15%; height: 5%; font-weight: bold;">Customer
									Name: <br /> <input type="text" name="customerName">
								</td>
								<td style="width: 15%; height: 5%; font-weight: bold;">Game:<br />
									<select name="customergameadd">
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
								<td colspan="3" style="height: 5%;"><input type="button"
									value="Add"
									style="background-color: #191970; color: #7FFFD4; font-weight: bold; padding: 2 2 2 2"
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