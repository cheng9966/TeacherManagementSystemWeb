<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>教师管理系统</title>
    <script src="js/jquery/jquery-2.1.1.min.js"></script>
    <link href="css/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="js/jquery/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/index.css">
    <script type="text/javascript" src="js/index.js"></script>
</head>
<body>
	<div class="container">
        <div class="form row">
            <div class="form-horizontal col-md-offset-3" id="login_form">
                <h3 class="form-title col-md-offset-2">LOGIN</h3>
                <div class="col-md-9">
                    <div class="form-group">
                        <i class="fa fa-user fa-lg"></i>
                        <input class="content-input form-control required" type="text" placeholder="Username" id="username" name="username" maxlength="20"/>
                    </div>
                    <div class="form-group">
                            <i class="fa fa-lock fa-lg"></i>
                            <input class="content-input form-control required" type="password" placeholder="Password" id="password" name="password" maxlength="8"/>
                    </div>
                    <br/>
                    <div class="form-group col-md-offset-8">
                        <button type="submit" id="loginBtn" class="btn btn-block btn-success full-right" data-toggle="modal" data-target="">登录</button>
                    </div>
                    <div class="form-group col-md-offset-8">
                        <button type="button" id="registBtn" class="btn btn-block btn-link full-right">注册</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
	 
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						&times;
					</button>
					<h4 class="modal-title" id="myModalLabel">
						错误
					</h4>
				</div>
				<div class="modal-body">
					登录失败,请检查你的账户和密码
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-info" data-dismiss="modal">确定
					</button>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal -->
	</div>
</body>
</html>