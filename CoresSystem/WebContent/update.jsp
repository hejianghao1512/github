<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<h2>修改密码</h2>
<link href="CSS/Treg.css" type="text/css" rel="stylesheet">
</head>
<body>
	<form action="Update" method="post">
		<table align="center" width="450" border="0">
			<tr>
				<td align="right">用 户 名：</td>
				<td><input type="text" name="T_username"></td>
			</tr>
			<tr>
				<td align="right">输 入 旧 密 码：</td>
				<td><input type="text" name="JT_password"></td>
			</tr>
			<tr>
				<td align="right">新 密 码：</td>
				<td><input type="password" name="NT_password"></td>
			</tr>
			<tr>
				<td align="right">确 认 新 密 码：</td>
				<td><input type="password" name="T_password"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit"value="修  改">
				</td>
				<td>
					<input type="button" value="返回" onclick="window.location.href=' T_message.jsp '" >
				</td>


			</tr>

		</table>
	</form>
</body>
</html>