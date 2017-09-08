<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
<meta charset="UTF-8">
<title>教师</title>
<link href="CSS/Login.css" type="text/css" rel="stylesheet">
<script>

        var radioCheck = document.getElementsByClassName("radioCheck");
        console.log(radioCheck);
        var loginBtn = document.getElementById("login");
        var registerBtn = document.getElementById("register");

       function loginGo(){
           
                window.location.href = "Slogin.jsp";
               
        }

       function registerGo(){
            
                window.location.href = "Treg.jsp";
               
            
            
        }
    </script>
</head>
<body>
	<h2>教务管理系统</h2>
	<div class="over">
		<form action="TLogin" method="post" onSubmit="return login(this);">
			<table align="center" width="300" border="0" class="tb 1">
				<tr>
					<td><input type="text" name="T_username" placeholder="用户名">
					</td>
				</tr>
				<tr>
					<td><input type="password" name="T_password" placeholder="密码">
					</td>
				</tr>
				<tr>
				<%
					String info =(String)request.getAttribute("info");
					if(info!=null){
						out.println(info);
				}%>
				</tr>
				<tr>
					<td>
						<div id="radioCheck">
							<input type="radio" name="identity" value="s" class="radioCheck"onclick="loginGo()">学生
							<input type="radio" name="identity" value="t"checked="checked" > 老师
						</div>
					</td>
				</tr>
				<tr>
					<td align="center" heigh="50">
					<input type="submit"value="登   陆" id="login">
					<input type="reset" value="重   置" id="reset">
					<input type="button" name="reg" value="注册" id="register"onclick="registerGo()"></td>
				</tr>

			</table>
		</form>
	</div>
</body>
</html>