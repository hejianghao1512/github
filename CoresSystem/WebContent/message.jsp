<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>教务系统</title>
 <link href="CSS/Tm.css" type="text/css" rel="stylesheet">
<style>
    body,html{
        margin: 0;
        padding: 0;
        width: 100%;
        overflow: hidden;
    }
    .banner{
        width: 100%;
    }
    ul{
        width: 100%;
        padding: 0;
        margin-top: 20px;
        margin: 0;
    }
    li{
        list-style: none;
        width: 15.9%;
        float: left;
        background-color: #210FB5;
        margin: 0;
        text-align: center;
        background-color: lightblue;
        font-weight: 500;
        padding-top: 10px;
        padding-bottom: 10px;
        border-right: 1px solid white;

    }
    li:hover{
        background-color: #210FB5;
    }
    li:visited{
        background-color: #210FB5;
    }
    a{
        text-decoration: none;
        color: white;

    }
</style>
</head>
 
<body>
<div id="nav">
    <img src='CSS/banner.png' class="banner">
    <ul>
        <li><a href="View" >选择课程</a></li>
        <li><a href="Supdate.jsp" >修改密码</a></li>
        <li><a href="#" >查看成绩</a></li>
        <li><a href="Sperson.jsp" >个人中心</a></li>
         <li><a href="Tlogin.jsp" >退出</a></li>
    </ul>
</div>
</body>
</html>