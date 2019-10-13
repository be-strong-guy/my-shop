<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>
<!DOCTYPE html>
<html>
<head>
    <title>AdminLTE 2 | Dashboard</title>
    <jsp:include page="../includes/header.jsp"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">


<div class="wrapper">
    <jsp:include page="../includes/nav.jsp"/>

    <jsp:include page="../includes/menu.jsp"/>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                类目管理
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
                <li class="active">类目管理</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${baseResult !=null}" >
                        <div class="alert alert-${baseResult.status == 200?"success":"danger"} alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                ${baseResult.message}
                        </div>
                    </c:if>


                </div>
            </div>


        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="../includes/copyright.jsp"/>
</div>
<jsp:include page="../includes/footer.jsp"/>
<sys:modal/>

<script>

    var _dataTables ;
    $(function () {
        var columns =  [
            {"data":function ( row, type, val, meta ) {
                    return '<input id="'+row.id+'" type="checkbox" class="minimal">';
                }},
            { "data": "id" },
            { "data": "username" },
            { "data": "phone" },
            { "data": "email" },
            { "data": "updated" },
            {"data":function ( row, type, val, meta ) {
                var urlDetail = "/user/detail?id="+row.id;
                    return '<button  type="button" class="btn btn-small btn-default" onclick="showDetail(\''+urlDetail+'\')"><i class="fa fa-search"></i> 查看</button>&nbsp;&nbsp;&nbsp;'+
                        '<a href="/user/form?id='+row.id+'" type="button" class="btn btn-small btn-primary"><i class="fa fa-edit"></i> 编辑</a>&nbsp;&nbsp;&nbsp;'+
                        '<a href="#" type="button" class="btn btn-small btn-danger"><i class="fa fa-trash"></i> 删除</a>';
                }},
        ];
        _dataTables = app.dataTables("/user/page",columns);
    });
    function search() {

        var usernmae = $("#username").val();
        var email = $("#email").val();
        var phone = $("#phone").val();
        var params = {
            "username":usernmae,
            "email":email,
            "phone":phone
        };
        _dataTables.settings()[0].ajax.data = params;
        _dataTables.ajax.reload();

    };
    
    function showDetail(url) {
        $.ajax({
            "url":url,
            "type":"get",
            "dataType":"html",
            success:function (data) {
                $("#modal-detail-body").html(data);
                $("#modal-detail").modal("show");

            }

        })
    }
</script>

</body>
</html>