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
                用戶信息
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
                <li class="active">用户信息</li>
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
                    <div class="box box-info box-info-search" style="display:none;" >
                        <div class="box-header">
                            <h3 class="box-tittle">搜索</h3>
                        </div>
                        <form:form  cssClass="form-horizontal" method="post" action="/user/search" modelAttribute="tbUser">
                            <div class="box-body">
                                <div class="row">
                                    <div class="col-xs-12 col-sm-3">
                                        <label for="email" class="col-sm-4 control-label ">邮箱</label>

                                        <div class="col-sm-8">
                                            <form:input path="email" cssClass="form-control"/>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 col-sm-3">
                                        <label for="username" class="col-sm-4 control-label ">用户名</label>

                                        <div class="col-sm-8">
                                            <form:input path="username" cssClass="form-control"/>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 col-sm-3">
                                        <label for="phone" class="col-sm-4 control-label ">手机号</label>

                                        <div class="col-sm-8">
                                            <form:input path="phone" cssClass="form-control"/>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="box-footer">
                                <button type="submit" class="btn btn-info pull-right">搜索</button>
                            </div>

                        </form:form>

                    </div>
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">用户列表</h3>
                        </div>

                        <div class="box-body">
                            <a href="/user/form" type="button" class="btn btn-small btn-default"><i class="fa fa-plus"></i> 新增</a>&nbsp;&nbsp;&nbsp;
                            <button  type="button" class="btn btn-small btn-default" onclick="app.deleteMulti('/user/delete')"><i class="fa fa-trash"></i> 删除</button>&nbsp;&nbsp;&nbsp;
                            <a href="#" type="button" class="btn btn-small btn-default"><i class="fa fa-download"></i> 下载</a>&nbsp;&nbsp;&nbsp;
                            <a href="#" type="button" class="btn btn-small btn-default"><i class="fa fa-upload"></i> 上传</a>&nbsp;&nbsp;&nbsp;
                            <button type="button" class="btn btn-small btn-primary" onclick="$('.box-info-search').css('display')=='none'?$('.box-info-search').show('fast'):$('.box-info-search').hide('fast')"><i class="fa fa-search"></i> 搜索</button>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body table-responsive ">
                            <table id="tableDatas" class="table table-hover">
                                <thead>
                                <tr>
                                    <th><input type="checkbox" class="minimal iCheck_master"></th>
                                    <th>ID</th>
                                    <th>用户名</th>
                                    <th>手机</th>
                                    <th>邮箱</th>
                                    <th>更新日期</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%--<c:forEach items="${TbUsers}" var="TbUsers" >
                                    <tr>
                                        <td><input id="${TbUsers.id}" type="checkbox" class="minimal"></td>
                                        <td>${TbUsers.id}</td>
                                        <td>${TbUsers.username}</td>
                                        <td>${TbUsers.phone}</td>
                                        <td>${TbUsers.email}</td>
                                        <td><fmt:formatDate value="${TbUsers.updated}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
                                        <td>
                                            <a href="#" type="button" class="btn btn-small btn-default"><i class="fa fa-search"></i> 查看</a>&nbsp;&nbsp;&nbsp;
                                            <a href="#" type="button" class="btn btn-small btn-primary"><i class="fa fa-edit"></i> 编辑</a>&nbsp;&nbsp;&nbsp;
                                            <a href="#" type="button" class="btn btn-small btn-danger"><i class="fa fa-trash"></i> 删除</a>
                                        </td>
                                    </tr>
                                </c:forEach>--%>
                                </tbody>
                            </table>
                        </div>
                    </div>
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
        app.dataTables("/user/page",columns);
    })

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