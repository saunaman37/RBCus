<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.Assembly" %>
<%@ page import="model.Part" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ASSEMBLY</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<%@include file = "header-navi.jsp"%>


	<h2>ASSEMBLY</h2>

	<%
		List<Part> listPrt;
	    Assembly assembly = (Assembly) session.getAttribute("assembly");
		if (assembly == null) {
			listPrt = new ArrayList<Part>();
		} else {
			listPrt = assembly.getListPrt();
		}
		if (listPrt.size() > 0) {
	%>
			<table class="assembly-list">
			<tr>
				<th></th><th>TYPE</th><th>NAME</th><th>WEIGHT</th><th>PRICE</th>
			</tr>
	<%
			for (int idx = 0; idx < listPrt.size(); idx++) {
				Part prt = listPrt.get(idx);
	%>
				<tr>
					<td>
						<form action="remove-prt-servlet" method="POST">
							<input type="hidden" name="idx" value="<%=idx%>">
							<input type="submit" value="削除">
						</form>
					</td>
					<td><%=prt.getId() %></td>
					<td><%=prt.getName() %></td>
					<td><%=prt.getWeightString() %></td>
					<td><%=prt.getPriceString() %></td>
				</tr>			
	<%
			}
	%>
			</table>
			<br>
			<form action="total-servlet" method="post">
				<input type="submit" value="完成"><br>
			</form>
				
	<%
		} else {
	%>
			<p>未構成</p>
	<%
		}
	%>

</body>
</html>