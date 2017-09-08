function writeMassage(loginState)
{
	if(loginState=='yes')
	{
		window.location.href="view/writeMasg.jsp";
	}
	if(loginState=='no')
	{
		alert("抱歉当前您还未登录，不能留言");
		$("#denglu").trigger("click");
	}
		
}
$(function(){
	$("#denglu").click(function(){
		var x=Math.floor(($(window).width()-340)/2);
		var y=Math.floor(($(window).height()-240)/2);
		console.log(x);
		console.log(y);
		$("#login").css({"left": x+"px","top": y+"px"});
		$("#loginBox").show();
	});
	$("#close").click(function(){
		$("#loginBox").hide();
	});
	$(window).resize(function() {
		var x=Math.floor(($(window).width()-340)/2);
		var y=Math.floor(($(window).height()-240)/2);
		console.log(x);
		console.log(y);
		$("#login").css({"left": x+"px","top": y+"px"});
	});
	$("#btn").click(function(){
		var username=$("#username").val();
		var pwd=$("#pwd").val();
		var post_data={"jusername":username,"jpwd":pwd};
		var url="login";
		$.post(url,post_data,function(data){
			if(data=="no")
			{
				alert("用户名或密码错误！");
			}
			else
			{
				$("#close").trigger("click");
				window.location.href="home";
			}
		});
	});
});