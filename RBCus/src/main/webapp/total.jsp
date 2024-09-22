<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.Assembly" %>
<%@ page import="model.Part" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TOTAL</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<%@include file = "header-navi.jsp"%>

	<h2>TOTAL</h2>

	<p>完成</p>

	<%
		List<Part> listPrt;
		Assembly totalData = (Assembly) session.getAttribute("total");
		if (totalData == null) {
			listPrt = new ArrayList<Part>();
		} else {
			listPrt = totalData.getListPrt();
		}
		if (listPrt.size() > 0) {
	%>
			<table class="tatal-list">
			<tr>
				<th>TYPE</th><th>NAME</th><th>WEIGHT</th><th>PRICE</th>
			</tr>
	<%
			for (Part prt : listPrt) {
	%>
				<tr>
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
			<p>合計：<%=totalData.getTotalWeightString() %> になります。</p>
			<% 
		      if (totalData.getTotalWeight() <= 6800) {
	%>
			<p class="error-msg">UCI重量制限（6.8kg以上）</p>
	<%
		} 
	%>
			<p>合計：<%=totalData.getTotalPriceString() %> になります。</p>

	<%
			session.removeAttribute("total");			// 完成済情報の削除
		} 
	%>

</body>
</html> 