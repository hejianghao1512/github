<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<h2>学生注册</h2>
<link href="CSS/Sreg.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="over">
	<form action="Sreg" method="post">
		<table align="center" width="450" border="0">
			<tr>
				<td align="right">用 户 名：</td>
				<td><input type="text" name="S_username"></td>
			</tr>
			<tr>
				<td align="right">密 码：</td>
				<td><input type="text" name="S_password"></td>
			</tr>
			<tr>
				<td align="right">学 号：</td>
				<td><input type="text" name="S_num"></td>
			</tr>
			<tr>
				<td align="right">姓 名：</td>
				<td><input type="text" name="S_name"></td>
			</tr>
			<tr>
				<td align="right">班 级：</td>
				<td><input type="text" name="S_class"></td>
			</tr>
			<tr>
				<td align="right">性 别：</td>
				<td><input type="radio" name="S_sex"class="radioCheck"value="男"checked="checked">男
				 <input type="radio" name="S_sex"class="radioCheck"value="女">女</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="注  册"> <input type="reset" value="重  置"></td>


			</tr>

		</table>
	</form>
</div>
</body>
</html>