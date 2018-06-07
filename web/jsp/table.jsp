<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>教师管理系统</title>
    <script src="../js/jquery/jquery-2.1.1.min.js"></script>
    <link href="../css/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="../js/jquery/bootstrap.min.js"></script>
    <script src="../js/jquery/bootstrap-table.js"></script>
    <script src="../js/jquery/bootstrap-table-zh-CN.js"></script>
    <link href="../css/bootstrap/bootstrap-table.css">
    <link href="../css/bootstrap/bootstrap-theme.css">

    <link rel="stylesheet" href="../css/table.css">
    <script type="text/javascript" src="../js/table.js"></script>
</head>
<body>
<div class="html container">
    <div class="header page-header">
        <h1>教师管理系统</h1>
    </div>
    <div class="table-contenet">
        <div class="searchBar">
            <div class="left">
                <input id="name" name="name" class="form-control" placeholder="请输入老师姓名"/>
                <button class="btn btn-primary" onclick="search()">搜索</button>
            </div>
            <div class="right">
                <button class="btn btn-success" data-toggle="modal" data-target="#addModal">新增</button>
                <button class="btn btn-danger" data-toggle="modal" onclick="deleteTeacher()">删除</button>
                <button class="btn btn-warning" data-toggle="modal" data-target="#updateModal">修改</button>
            </div>
        </div>
        <div class="data">
            <table id="table" class="table table-bordered"></table>
        </div>
    </div>
</div>

<!-- 新增弹框 -->
<div id="addModal" class="modal fade" role="dialog"
     aria-labelledby="gridSystemModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">新增</h4>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-12 col-md-12">
                        <h4>姓名：</h4>
                        <input type="text" id="teacherName" name="teacherName" autofocus="autofocus"
                               class="form-control" aria-describedby="basic-addon1"/>
                    </div>
                    <div class="col-xs-12 col-md-12">
                        <h4>生日：</h4>
                        <input type="date" id="teacherBirthday" name="teacherBirthday"
                               class="form-control" aria-describedby="basic-addon1"/>
                    </div>
                    <div class="col-xs-12 col-md-12">
                        <h4>性别：</h4>
                        <input type="text" id="teacherSex" name="teacherSex"
                               class="form-control" aria-describedby="basic-addon1"/>
                    </div>
                    <div class="col-xs-12 col-md-12">
                        <h4>薪水：</h4>
                        <input type="number" id="teacherSalary" name="teacherSalary"
                               class="form-control" aria-describedby="basic-addon1"/>
                    </div>
                    <div class="col-xs-12 col-md-12">
                        <h4>邮箱：</h4>
                        <input type="text" id="teacherEmail" name="teacherEmail"
                               class="form-control" aria-describedby="basic-addon1"/>
                    </div>
                    <div class="col-xs-12 col-md-12">
                        <h4>老师专业：</h4>
                        <input type="text" id="teacherType" name="teacherType"
                               class="form-control" aria-describedby="basic-addon1"/>
                    </div>
                    <div class="col-xs-12 col-md-12">
                        <h4>职称：</h4>
                        <input type="text" id="teacherLevel" name="teacherLevel"
                               class="form-control" aria-describedby="basic-addon1"/>
                    </div>
                    <div class="col-xs-12 col-md-12">
                        <h4>工作地点：</h4>
                        <input type="text" id="teacherAddress" name="teacherAddress"
                               class="form-control" aria-describedby="basic-addon1"/>
                    </div>
                    <div class="col-xs-12 col-md-12">
                        <h4>备注：</h4>
                        <textarea id="remark" cols="6" name="remark"
                                  class="form-control" aria-describedby="basic-addon1"></textarea>
                    </div>
                </div>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal" onclick="clear()">关闭</button>
                <button type="button" class="btn btn-primary" onclick="add()">新增</button>
            </div>
        </div>
    </div>
</div>

<!-- 修改模态框（Modal） -->
<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-hidden="true">×
                </button>
                <h4 class="modal-title" id="updateModalLabel">
                    修改
                </h4>
            </div>
            <div class="modal-body">
                按下 ESC 按钮退出。
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default"
                        data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary">
                    提交更改
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- 删除模态框（Modal） -->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-hidden="true">×
                </button>
                <h4 class="modal-title" id="deleteModalLabel">
                    提示
                </h4>
            </div>
            <div class="modal-body deleteTeacher">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-info" data-dismiss="modal">确定
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    提示
                </h4>
            </div>
            <div class="modal-body alertP">
            </div>
            <div class="modal-footer">
                <button type="button" id="btnOk" class="btn btn-info" data-dismiss="modal">确定
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
</html>