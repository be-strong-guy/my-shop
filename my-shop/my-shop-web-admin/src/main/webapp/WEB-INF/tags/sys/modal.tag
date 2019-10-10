<%@ tag language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="tittle" type="java.lang.String" required="false" description="模态框标题" %>
<%@ attribute name="message" type="java.lang.String" required="false" description="模态框消息" %>
<%@ attribute name="opts" type="java.lang.String" required="false" description="操作類型 ：info/信息提示 confirm/确认对话框" %>
<%@ attribute name="url" type="java.lang.String" required="false" description="删除时跳转链接" %>


<div class="modal fade" id="modal-default">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">${tittle==null?"提示":tittle}</h4>
            </div>
            <div class="modal-body">
                <p id="modal-message">${message}&hellip;</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default pull-left" data-dismiss="modal">关闭</button>
                <button id="myModal" type="button" class="btn btn-primary">确认</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->
