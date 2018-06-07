
$(function () {
    initTable();
});

function initTable() {
    $("#table").bootstrapTable({
        url: '../servlet/TableServlet',
        contentType: 'application/json',// 发送到服务器的数据编码格式
        method: 'post',
        dataType: 'json',
        search: false,
        striped: false,
        pagination: true,
        pageSize: 10,
        pageNumber: 1,
        showRefresh: false,
        pageList: [10, 20, 30],
        clickToSelect: true,
        cache: false, //禁用缓存
        toolbar: '#toolbar',
        columns: [{
            width: '3',
            align: "center",
            valign: "middle",
            checkbox: true,
        }, {
            title: '序号',
            align: 'center',
            valign: 'middle',
            width: '5',
            formatter: function (value, row, index) {
                return index + 1;
            }
        }, {
            field: 'id',
            title: '教师ID',
            align: 'center',
            valign: 'middle',
            width: '5',
        }, {
            field: 'teacherName',
            title: '姓名',
            align: "center",
            valign: "middle",
            width: '10',
        }, {
            field: 'teacherSex',
            title: '性别',
            align: "center",
            valign: "middle",
            width: '10',
        }, {
            field: 'teacherSalary',
            title: '薪水',
            align: "center",
            valign: "middle",
            width: '10',
        }, {
            field: 'teacherBirthday',
            title: '生日',
            align: "center",
            valign: "middle",
            width: '5',
        }, {
            field: 'teacherEmail',
            title: '邮件',
            align: "center",
            valign: "middle",
            width: '30',
        }, {
            field: 'teacherType',
            title: '老师专业',
            align: "center",
            valign: "middle",
            width: '30',
        }, {
            field: 'teacherLevel',
            title: '职称',
            align: "center",
            valign: "middle",
            width: '40',
        }, {
            field: 'teacherAddress',
            title: '工作地点',
            align: "center",
            valign: "middle",
            width: '50',
        }, {
            field: 'remark',
            title: '备注',
            align: "center",
            valign: "middle",
            width: '50',
        }]
    });
}

function search1() {
    $('#table').bootstrapTable('destroy');
    initTable();
}

// 搜索方法
function search() {
    var teacherName = $("#name").val();
    ajaxParameter = {
        "teacherName": teacherName
    };
    $.ajax({
        url: '../servlet/SearchServlet',
        method: 'post',
        data: {
            teacherName: teacherName
        },
        dataType: 'json',
        success: function(result) {
            alert(result);
        }
    });
}

// 新增方法
function add() {
    var teacherName = $("#teacherName").val();
    var teacherBirthday = $("#teacherBirthday").val();
    var teacherSex = $("#teacherSex").val();
    var teacherSalary = $("#teacherSalary").val();
    var teacherEmail = $("#teacherEmail").val();
    var teacherType = $("#teacherType").val();
    var teacherAddress = $("#teacherAddress").val();
    var teacherLevel = $("#teacherLevel").val();
    var remark = $("#remark").val();

    $.ajax({
        url: '../servlet/AddServlet',
        method: '',
        async: false,
        data: {
            teacherName: teacherName,
            teacherBirthday: teacherBirthday,
            teacherSalary: teacherSalary,
            teacherSex: teacherSex,
            teacherEmail: teacherEmail,
            teacherType: teacherType,
            teacherLevel: teacherLevel,
            teacherAddress: teacherAddress,
            remark: remark
        },
        success: function (result) {
            if (result == "true") {
                $('#addModal').modal('hide');
                $(".alertP").append("<span>新增成功</span>");
                $('#myModal').modal('show');
                refresh();
            } else {
                $('#addModal').modal('hide');
                $(".alertP").append("<span>新增失败</span>");
                $('#myModal').modal('show');
            }
            clear();
        }
    });
}

// 删除方法
function deleteTeacher() {
    var data = $('#table').bootstrapTable("getSelections");

    if (data.length === 0) {
        $(".deleteTeacher").append("<span>请至少选择一条数据</span>");
        $("#deleteModal").modal('show');
        return;
    }

    var ids = "";
    for (var i = 0; i < data.length; i++) {
        if (i === 0) {
            ids += data[i].id;
            continue;
        }
        ids += "," + data[i].id;
    }
    console.log('-------------',ids);

    $.ajax({
        url: '../servlet/DeleteServlet',
        method: 'post',
        async: false,
        data: {
          ids: ids
        },
        success: function (result) {
            if (result == 'true') {
                alert("删除成功");
                refresh();
            }
        }
    });
}

// 输入框验证
$(function () {
    $("#teacherName").blur(function () {
        var teacherName = $("#teacherName").val();

        if (teacherName == "") {
            var $parent = $("#teacherName").parent();
            $parent.append("<span class='msg' style='color: red'>*姓名不能为空</span>");
        } else {
            var $parent = $("#teacherName").parent();
            $parent.find(".msg").remove();
        }
    });

    $("#teacherBirthday").blur(function () {
        var teacherBirthday = $("#teacherBirthday").val();

        if (teacherBirthday == "") {
            var $parent = $("#teacherBirthday").parent();
            $parent.append("<span class='msg' style='color: red'>*生日不能为空</span>");
        } else {
            var $parent = $("#teacherBirthday").parent();
            $parent.find(".msg").remove();
        }
    });
});

// 清空新增弹出框中的输入框的值
function clear() {
    $("#teacherName").val("");
    $("#teacherBirthday").val("");
    $("#teacherLevel").val("");
    $("#teacherAddress").val("");
    $("#teacherType").val("");
    $("#teacherSalary").val("");
    $("#teacherSex").val("");
    $("#teacherEmail").val("");
    $("#remark").val("");
}

/* 刷新方法 */
function refresh() {
    $("#name").val("");
    $('#table').bootstrapTable('refresh', null);
}