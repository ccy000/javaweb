<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<html>
<head>
    <style>
        h2{
        height:140px;
        width:900px;
        background:darkred;
        font-size: 30px; 
        }
        div{
        height:400px;
        width:900px;
        background: blue;
        
        }
        div ul{
          list-style:none;
        }
        div ul li{
            margin-left:280px;
           font-size: 20px;  
        } 
    </style>
    <script type="text/javascript">
       function as()
        { 
    	   if(document.getElementById("username").value=="")//form1.name.value==""
		   {
			   alert("用户名不能为空");
			 return false;
			
			   }
		   if(document.getElementById("password").value=="")
			   {
			   alert("密码不能为空！");
			 return false;
			   }
        }
    </script>
<title>主页面</title>
</head>
<body>
  
  <h2 align="center"> <br>用户管理系统</h2>
  <div>
    <form action="登录" method="post" name="">
    <ul>
      <br><br> <br><br>
      <li>用户名：<input type="text" name="username" id="username" placeholder="用户名"></li><br>
      <li>密码：<input type="password" name="password" id="password" placeholder="密码"></li><br>
      <li><input type="submit" name="sub" value="登录" onclick="as()" >&nbsp; &nbsp; &nbsp; 
           <input type="reset" value="重置" ></li>
     
    </ul>
    </form>
</div>
</body>
</html>