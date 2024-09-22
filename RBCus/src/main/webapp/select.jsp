<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.Factory" %>
<%@ page import="model.Part" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PARTS SELECTION</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<%@include file = "header-navi.jsp"%>
	
	<%
		List<Part> listPrt;
	    Factory factory = (Factory) session.getAttribute("factory");
		if (factory == null) {
			listPrt = new ArrayList<Part>();
		} else {
			listPrt = factory.getListPrt();
		}
		if (listPrt.size() > 0) {
	%>

			<h2>PARTS SELECTION</h2>
			<p>パーツを選択して、自分好みのロードバイクを作ろう！！</p>
			

			<table class="select-list">
			<tr>
				<th></th><th>TYPE</th><th>NAME</th><th>WEIGHT</th><th>PRICE</th>
			</tr>
				
	<%
			for (int idx = 0; idx < listPrt.size(); idx++) {
				Part prt = listPrt.get(idx);
	%>
				<tr>
					<td>
						<form action="add-prt-servlet" method="POST">
							<input type="hidden" name="idx" value="<%=idx%>">
							<input type="submit" value="選択">
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

	<%
		}
	%>

</body>
</html>