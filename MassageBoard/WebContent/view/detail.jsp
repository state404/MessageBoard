<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8">
		<link rel="stylesheet" type="text/css" href="static/css/style.css">
	</head>
	<body>
		<div class="container">
			<div>
				<div>标题:${masg.title }</div>
				<div class="item"></div>
				<div>内容:${masg.contentText }</div> 
				<div class="item"></div>
				<div>配图:</div> 
				<div class="item">
					<c:forEach items="${pics}" var="pic">
						<img src="static/upload/${pic}" width="180" height="120">
					</c:forEach>
				</div>
				<div class="item">
					<span>留言人: ${masg.user.username }</span>
					<span>留言时间:${masg.showTime }</span>
				</div>
			</div>
			<div>
				<a class="button" href="javascript:history.back()">返回</a>
			</div>
		</div>
	</body>
</html>