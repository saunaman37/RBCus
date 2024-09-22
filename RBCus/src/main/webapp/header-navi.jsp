<%@ page pageEncoding="UTF-8"%>
<%@ page import="model.Assembly" %>
<%@ page import="model.Factory" %>

	<%-- 工場・ユーザIDの表示 --%>
	<% 
	    Factory factoryHdr = (Factory) session.getAttribute("factory");
	    Assembly assemblyHdr = (Assembly) session.getAttribute("assembly");
		if ((factoryHdr == null) || assemblyHdr == null) {
			request.setAttribute("errorMsg", "再ログインをお願いします。");	
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
	%>
			<h1><%=factoryHdr.getName() %></h1>
			<hr>
			ユーザID：<%=assemblyHdr.getUserId() %>
			<hr>

			<%-- ナビ表示 --%>
			｜<a href="select.jsp">PARTS SELECTION</a>
			｜<a href="assembly.jsp">ASSEMBLY</a>
			｜<a href="logout-servlet">LOGOUT</a>｜
			<hr>
	<%
		}
	%>
