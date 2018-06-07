// 注册方法
$(document).ready(function() {
	$("#registBtn").attr('disabled', true);
	
	$("#password").blur(function() { // 对密码输入框进行聚焦的验证，当焦点从输入框中移出时就进行验证看是否合理
		var password = $("#password").val();
		var passwordConfirm = $("#password-confirm").val();
		
		if (password == "") {
			var $parent = $("#password").parent();
			$parent.find(".msg").remove();
			
			var $required = $("<strong class='msg' style='color:red'>输入框不能为空</strong>");
			$("#password").parent().append($required);
			$("#registBtn").attr('disabled', true);
		} else {
			var $parent = $("#password").parent();
			$parent.find(".msg").remove();
			
			if (password == passwordConfirm) {
				$("#registBtn").attr('disabled', false);
			}
		}
	});
	
	$("#password-confirm").blur(function() {// 对密码确定输入框进行聚焦的验证，当焦点从输入框中移出时就进行验证看是否
		var password = $("#password").val();
		var passwordConfirm = $("#password-confirm").val();
		
		if (passwordConfirm == "") {
			var $parent = $("#password-confirm").parent();
			$parent.find(".msg").remove();
			
			var $required = $("<strong class='msg' style='color:red;'>输入框不能为空</strong>");
			$parent.append($required);
			$("#registBtn").attr('disabled', true);
		} else {
			var $parent = $("#password-confirm").parent();
			$parent.find(".msg").remove();
			
			if (password == passwordConfirm) {
				$("#registBtn").attr('disabled', false);
			} else {
				var $required = $("<strong class='msg' style='color:red;'>两次密码不一致</strong>");
				$parent.append($required);
			}
		}
	});
	
	$("#registBtn").click(function() {
		
		var $parent = $("#password-confirm").parent();
		$parent.find(".msg").remove();
		$parent = $("#password").parent();
		$parent.find(".msg").remove();
		
		var password = $("#password").val();
		var passwordConfirm = $("#password-confirm").val();
		$.ajax({
			url: '../servlet/RegistServlet',
			method: 'post',
			async: false, // 不让ajax异步请求
			data: {
				password: password
			},
			success: function(result) {
				if (result == "false") {
					$(".modal-body").append("<span>注册失败</span>");
					$("#registBtn").attr('data-target', '#myModal');
				} else {
					$(".modal-body").append("<span>注册成功，您的账户为：" + result + "</span>");
					$("#registBtn").attr('data-target', '#myModal');
				}
			}
		});
	});
});

$(document).ready(function() {
	$("#btnOk").click(function() {
		setInterval(function() {
			window.location.href = "http://localhost:8080/TeacherManagementSystemWeb/index.jsp";
		}, 2000);
	});
});