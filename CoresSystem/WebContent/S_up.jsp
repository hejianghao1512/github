<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	String info = (String)request.getAttribute("info");
	if(info!=null)
		out.println(info);
%>

 <table align="center" > 
		 	<td align="center" >
				<input type="button" value="返回" onclick="window.location.href=' message.jsp '" >
			</td>
</table>

</body>
</html>