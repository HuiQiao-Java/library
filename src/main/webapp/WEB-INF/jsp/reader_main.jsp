<%--
  Created by IntelliJ IDEA.
  User: 君行天下
  Date: 2017/7/30
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>${readercard.name}的主页</title>
<link rel="stylesheet" href="static/css/bootstrap.min.css">
<script src="static/js/jquery-3.2.1.js"></script>
<script src="static/js/bootstrap.min.js"></script>
<style>
body {
	background-color: rgb(240, 242, 245);
}
</style>
</head>
<body>
<body>
	<nav class="navbar navbar-default" role="navigation"
		style="background-color: #fff" style="background-color:#fff">
		<div class="container-fluid">
			<div class="navbar-header" style="margin-left: 8%; margin-right: 1%">
				<a class="navbar-brand " href="reader_main.html">
				<p class="text-primary">我的图书馆</p></a>
			</div>
			<div class="collapse navbar-collapse" id="example-navbar-collapse">
				<ul class="nav navbar-nav navbar-left">
					<li class="active"><a id="book_button" href="#"> 图书查询
					</a></li>
					<li><a href="#" id="user_button"> 个人信息
					</a></li>
					<li><a href="#" id="lend_button"> 我的借还 </a></li>
					<li><a href="#" id="pas_button"> 密码修改 </a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="reader_info.html"><span
							class="glyphicon glyphicon-user"></span>&nbsp;${readercard.name}，已登录</a></li>
					<li><a href="login.html"><span
							class="glyphicon glyphicon-log-in"></span>&nbsp;退出</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<section id="mainContentId"
		style="position: relative; top: 7%; width: 80%; margin-left: 10%">
		
		
	</section>
	
	<script type="text/javascript">
		  $(function(){
    	 doLoadUI("#user_button","user/listUI.do");
    	
      	})
      function doLoadUI(id,url){
    	  $(id).click(function(){
         	   $("#mainContentId").load(url,function(){
         	   		//保证每次点击之后都会把原来的数据清空
         	   		$("#mainContentId").removeData();
         	   });
          });
      }

	</script>

</body>
</html>
