<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.zucc.hjh.model.Tuser"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="CSS/person.css" type="text/css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<%
	
	Tuser tuser = (Tuser)session.getAttribute("tuser");
	
%>
	<h2>个人中心</h2>
	<table align="center" width="350" border="2" height="200"
		bordercolor="#E8F4CC">
		
		<tr>
			<td align="right">用 户 名：</td>
			<td><%=tuser.getT_username() %></td>
		</tr>
		<tr>
			<td align="right">密   码：</td>
			<td><%=tuser.getT_password() %></td>
		</tr>
		<tr>
			<td align="right">名   字：</td>
			<td><%=tuser.getT_name() %></td>
		</tr>
		<tr>
			<td align="right">编   号：</td>
			<td><%=tuser.getT_num() %></td>
		</tr>
		<tr>
			<td align="right">性  别：</td>
			<td><%=tuser.getT_sex()%></td>
		</tr>

	</table>
		 <table align="center" > 
		 	<td align="center" >
				<input type="button" value="返回" onclick="window.location.href=' T_message.jsp '" >
			</td>
		</table>
	

</body>
</html>