<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link href="CSS/Login.css" type="text/css" rel="stylesheet">
    <script>

        var radioCheck = document.getElementsByClassName("radioCheck");
        console.log(radioCheck);
        var loginBtn = document.getElementById("login");
        var registerBtn = document.getElementById("register");

       function loginGo(){
           
           
                window.location.href = "Tlogin.jsp";
          
        }

       function registerGo(){
           
                window.location.href = "Sreg.jsp";
                console.log("Sreg.jsp");
           
        }
    </script>
</head>
<body>
    <h2>教务管理系统</h2>
        <div class="over">
            <form action="SLogin" method="post" onSubmit="return login(this);">
                <table align="center" width="300" border="0" class="tb 1">
                    <tr>
                    	<%
					String info =(String)request.getAttribute("info");
					if(info!=null){
						out.println(info);
				}%>
                        <td>
                            <input type="text" name="S_username" placeholder="用户名">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="password" name="S_password" placeholder="密码">
                        </td>
                    </tr>
                    <tr>
                        <td>
                           <div id = "radioCheck">
                               <input type="radio" name="identity" value="s" checked="checked" class="radioCheck"> 学生
                               <input type="radio" name="identity" value="t" class="radioCheck"onclick="loginGo()"> 老师
                           </div>
                        </td>
                    </tr>
                    <tr>
                        <td  align="center"heigh="50">
                            <input type="submit"value="登   陆" id = "login" >
                            <input type="reset"value="重   置" id="reset">
                            <input type="button" name="reg" value="注册" id="register" onclick="registerGo()">
                        </td>
                    </tr>

                </table>
            </form>
        </div>
</body>
</html>