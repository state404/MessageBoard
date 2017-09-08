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
				<form action="../addmasg" method="post" id="form" enctype="multipart/form-data">
					<div>标题:</div>
					<div class="item">
						<input type="text" name="title" size="36">
					</div>
					<div>内容:</div> 
					<div class="item">
						<textarea rows="10" cols="100" name="content"></textarea>
					</div>
					<div>配图:</div> 
					<div class="item">
						<input type="file" name="photos" multiple>
					</div>
					<div>
						<!-- 点击"发表"发布留言 -->
						<a class="button" href="javascript:submit()">发表</a>
						<!-- 点击"放弃"回到查看留言页面 -->
						<a class="button" href="../home">放弃</a>
					</div>
				</form>
			</div>
		</div>
		<script>
			function submit() {
				document.getElementById("form").submit();
			}
		</script>
	</body>
</html>