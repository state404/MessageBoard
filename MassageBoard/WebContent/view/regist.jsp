<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../static/css/registe.css" />
</head>
<body>
	<div class="header"></div>
	<div class="content">
		<div class="regist">
			<form action="../UserRegistServlet" method="post">
				<input type="text" name="rguname" placeholder="您的账户名和登录名" id="rgusername"><p id="note1"></p>
				<input type="password" name="rgpwd" placeholder="至少建议使用两种字符组合" id="rgpwd"><p id="note2"></p>
				<input type="password" placeholder="再次输入密码" id="repwd"><p id="note3"></p>
				<input type="submit" value="注册" style="background-color: red;" id="btn">
			</form>
		</div>
	</div>
	<div class="footer"></div>
</body>
<script type="text/javascript" src="../static/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="../static/js/regist.js"></script>
</html>