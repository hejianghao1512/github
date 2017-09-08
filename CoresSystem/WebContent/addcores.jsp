<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <style>
        form{
            width: 80%;
            margin: auto;

        }
        table{
            width: 80%;
            margin: auto;
        }
        tr{
            height: 80px;
        }
        input[type = 'text']{
            width: 100%;
            height: 70px;
            border: none;
            font-size:30px;
        }
        .btn{
            text-align: center;
            margin-top: 100px;
        }
        .btn>input{
            width: 300px;
            height: 70px;
            margin-left: 50px;
            background-color: cornflowerblue;
            color: white;
            border: none;
            border-radius: 20px;
            font-size:30px;
            
        }
        .title{
            background-color: lightblue;
        }
        h2{
            font-size: 60px;
            background-color: lightskyblue;
            text-align: center;
        }
    </style>
</head>
<body>

<form action="Add" method="post">
    <h2>添加课程</h2>
	<table align="center" border="1">
		<tr class="title">
			<td align="center">课 程 编 号</td>
			<td align="center">课 程 名</td>
			<td align="center">课 程 学 分</td>		
		</tr>
		<tr>
			<td>
				<input type="text" name="cNo">
			</td>
			<td>
				<input type="text" name="coresname">
			</td>
			<td>
				<input type="text" name="credit">
			</td>			
		
		</tr>
	</table>
   <div class="btn">
       <input type="submit" value="添  加">
   </div>
</form>
	<h2>已添加课程</h2>
		<table align="center" border="1">
		<tr class="title">
			
			<td align="center">课 程 编 号</td>
			<td align="center">课 程 名</td>
			<td align="center">课 程 学 分</td>		
		</tr>
		<%List<List> list=(List)session.getAttribute("list"); 
		  if(list!=null){			  
			  for(int i=0;i<list.get(0).size();i++){
				  %>
		<tr>
			
			<td>
				<%=list.get(0).get(i) %>
			</td>
			<td>
				<%=list.get(1).get(i) %>
			</td>
			<td>
				<%=list.get(2).get(i) %>
			</td>		
			<td>
				
				 <input type="button" value="删  除"onclick="location='delet?id=<%=list.get(0).get(i) %>'">
			</td>
		</tr>
		<%}} %>

		
	</table>
    <div class="btn">
   
	
        <input type="button" value="返回" onclick="window.location.href=' message.jsp '" >

    </div>
</form>

</body>
</html>