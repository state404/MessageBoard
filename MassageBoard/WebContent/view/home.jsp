<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<title>查看留言</title>
		<link rel="stylesheet" type="text/css" href="static/css/style.css">
		<link rel="stylesheet" type="text/css" href="static/css/login.css" />
	</head>
	<body>
		<div class="loginBox" id="loginBox">
   			<div class="login" id="login">
   				<div id="close">X</div>
   				<form action="#" method="post">
   					<div>
   						<p>用户名</p><input type="text"  name="username" id="username"/>
   					</div>
   					<div>
   						<p>密&nbsp;码</p><input type="password" name="pwd" id="pwd"/>
   					</div>
   					<input type="button" value="登录" id="btn" />
   				</form>
   			</div>
   		</div>
		<div class="container">
			<c:if test="${sessionScope.loginState=='no' }">
				<div id="huanyin"></div>
				<div class="button" id="denglu">登录</div>
			</c:if>
			<c:if test="${sessionScope.loginState=='yes' }">
				<div id="huanyin">欢迎用户${sessionScope.username},</div>
				<a class="button" href="clear">注销</a>
			</c:if>
			<a href="view/regist.jsp">免费注册</a>
			<div align="right">
				<!-- 点击"写留言"如果已经登录就进入写留言页面否则进入登录页面 -->
				<a class="button" href="javascript:writeMassage('${sessionScope.loginState}')">写留言</a>
			</div>
			<!-- 此处需要通过循环控制每页显示5条留言按时间降序排列 -->
			<c:forEach items="${mlist}" var="massage">
				<div>
					<div>
						<!-- 点击标题查看留言详情 -->
						<p>留言标题：<a href="detailed?id=${massage.id }">${massage.title }</a></p>
						<p>
							<span>留言人：${massage.user.username }</span>
							<span>留言时间：${massage.showTime }</span>
							<!-- 点击删除链接可以删除自己发表的留言 -->
							<c:if test="${sessionScope.loginState=='yes' }">
								<c:if test="${sessionScope.username==massage.user.username }">
									<a href="delmasg?id=${massage.id }">删除</a>
								</c:if>
							</c:if>
						</p>
					</div>
					<hr>
				</div>
			</c:forEach>
			<!-- 此处需要实现翻页功能 -->
			<div align="center">
				${page.firstPage}
				${page.prePage}
				${page.pNum1}
				${page.pNum2}
				${page.nowPage}
				${page.pNum3}
				${page.pNum4}
				${page.nextPage }
				${page.lastPage}
			</div>
		</div>
	</body>
<script src="static/js/jquery-3.2.1.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript" src="static/js/massage.js"></script>
</html>