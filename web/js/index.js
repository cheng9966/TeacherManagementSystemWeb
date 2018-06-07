// 注册跳转
$(document).ready(function(){
	$("#registBtn").click(function(){
		window.location.href = "http://localhost:8080/TeacherManagementSystemWeb/jsp/regist.jsp";
	});
});

// 登录方法
$(function(){
	$("#loginBtn").attr('disabled',true);
	$("#username").blur(function() {
		var account = $("#username").val();
		var password = $("#password").val();
		
		if (account == "") {
			var $parent = $("#username").parent();
			$parent.find(".msg").remove(); //删除以前的提醒元素
			 //创建元素
			 var $required = $("<strong class='msg' style='color:red'>账户不能为空</strong>");
			 //将它追加到文档中
			 $("#username").parent().append($required);
			 $("#loginBtn").attr('disabled',true);
		} else if (!(/^[0-9]+$/).test(account)) {
			var $parent = $("#username").parent();
			$parent.find(".msg").remove(); //删除以前的提醒元素
			var $required = $("<strong class='msg' style='color:red'>账户全是数字</strong>");
			$("#username").parent().append($required);
			$("#loginBtn").attr('disabled',true);
		} else {
			var $parent = $("#username").parent();
			$parent.find(".msg").remove(); //删除以前的提醒元素
			if (password != "") {
				$("#loginBtn").attr('disabled',false);
			}
		}
	});
	
	$("#password").blur(function() {
		var account = $("#username").val();
		var password = $("#password").val();
		
		if (password == "") {
			$parent = $("#password").parent();
			$parent.find(".msg").remove();
			var $required = $("<strong class='msg' style='color:red'>密码不能为空</strong>");
			$("#password").parent().append($required);
			$("#loginBtn").attr('disabled',true);
		} else {
			var $parent = $("#password").parent();
			$parent.find(".msg").remove(); //删除以前的提醒元素
			if (account != "") {
				$("#loginBtn").attr('disabled',false);
			}
		}
	});
	
	$("#loginBtn").click(function(){		
		var account = $("#username").val();
		var password = $("#password").val();

			var $parent = $("#username").parent();
			$parent.find(".msg").remove(); //删除以前的提醒元素
			$parent = $("#password").parent();
			$parent.find(".msg").remove(); //删除以前的提醒元素
			$.ajax({
				url: 'servlet/LoginServlet',
				method: 'get',
				async: false,
				data: {
					username: account,
					password: password
				},
				success: function(result) {
					if (result == "true") {
						setInterval(function(){
							window.location.href = "http://localhost:8080/TeacherManagementSystemWeb/jsp/table.jsp";
						}, 2000);
					} else {
						$("#loginBtn").attr('data-target', '#myModal');
					}
				}
			});
		});
});