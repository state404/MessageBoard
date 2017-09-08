$(function(){
	var arr=new Array(0,0,0);
	$("#rgusername").focus(function(){
		$("#note1").html("");
	});
	$("#rgpwd").focus(function(){
		$("#note2").html("");
	});
	$("#repwd").focus(function(){
		$("#note3").html("");
	});
	$("#rgusername").blur(function(){
		if($("#rgusername").val()=="")
		{
			$("#note1").html("值不能为空");
			arr[0]=0;
		}
		else
		{
			var url="../checkuser";
			var post_data={"username":$("#rgusername").val()};
			$.post(url,post_data,function(data){
				if(data=="yes")
				{
					arr[0]=0;
					$("#note1").html("用户名已存在");
				}
				else
				{
					arr[0]=1;
				}
			});
			
		}
		check (arr);
	});
	$("#rgpwd").blur(function(){
		if($("#rgpwd").val()=="")
		{
			$("#note2").html("值不能为空");
			arr[1]=0;
		}
		else
		{
			arr[1]=1;
		}
		check (arr);
	});
	$("#repwd").blur(function(){
		if($("#repwd").val()=="")
		{
			$("#note3").html("值不能为空");
			arr[2]=0;
		}
		else if($("#rgpwd").val()!=$("#repwd").val())
		{
			$("#note3").html("密码不一致");
			arr[2]=0;
		}
		else
		{
			arr[2]=1;
		}
		 check (arr);
	});
	
});
function check (arr)
{
	var cnt=0;
	for(i in arr)
	{
//		console.log(arr[i]);
		if(arr[i]!=0)
		{
			cnt++;
		}
	}
//	console.log(cnt);
	if(cnt>=3)
	{
		$("#btn").show();
	}
	else
	{
		$("#btn").hide();
	}
	
}