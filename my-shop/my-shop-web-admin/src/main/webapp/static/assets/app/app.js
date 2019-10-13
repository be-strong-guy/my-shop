/**
 * 函数对象
 */
var app = function () {
    //iCheck相关内容
    var iCheck_master;
    var iCheck_all;

    //保存id的数组
    var ids = new Array();
    /**
     * 私有方法
     *
     */
    var handlerInitIcheck = function () {
        //iCheck for checkbox and radio inputs
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass   : 'iradio_minimal-blue'
        });

        iCheck_master = $('input[type="checkbox"].minimal.iCheck_master');
        iCheck_all = $('input[type="checkbox"].minimal');
    };

    var handlerInitIcheckAll =  function () {
        iCheck_master.on('ifClicked',function (e) {
            // 当前状态已选中，点击后应取消选择
            if(e.target.checked){
                iCheck_all.iCheck("uncheck");
            }else {
                // 当前状态未选中，点击后应全选
                iCheck_all.iCheck("check");
            }
        })
    };

    /**
     * 批量删除
     * @param url
     */
    var handlerInitDeleteMulti = function (url) {

        iCheck_all.each(function () {
            var _id = $(this).attr("id");
            if(_id!=null&&_id!="undefine"&&$(this).is(":checked")){
                ids.push(_id);
            }
        });
        if(ids.length===0){
            $("#modal-message").html("请选择最少一项内容！");
        }else {
            $("#modal-message").html("您确认删除吗？");
        }

        $("#modal-default").modal("show");

        $("#myModal").bind('click',function () {
            del();
        });

        var del = function () {
            $("#modal-default").modal("hide");
            if(ids.length===0){
                //
            }else {
                setTimeout(function () {
                    $.ajax({
                        "url":url,
                        "type":"POST",
                        "data":{"ids":ids.toString()},
                        "dataType":"JSON",
                        "success":function(e){
                            //先解绑它的方法
                            $("#myModal").unbind("click");
                            if(e.status==200){
                                //当重新刷新时候，绑定的click方法也会消失，否则下次点击确认会删除多次
                                $("#myModal").bind('click',function () {
                                    window.location.reload();
                                });

                            }else {

                                //再重新绑定方法
                                $("#myModal").bind('click',function () {
                                    $("#modal-default").modal("hide");
                                });

                            }
                            //弹出模态框提示
                            $("#modal-message").html(e.message);
                            $("#modal-default").modal("show");
                            //下面这个方式不太行，因为$("#myModal")绑定的方法不会消失，会执行很多次,会有问题
                            /*ids=new Array();
                            $("#modal-message").html(e.message);
                            $("#modal-default").modal("show");*/

                        }
                    })
                },500)
            }
        }
    };

    var handlerInitDateTables = function (url,columns) {

       var _dataTables =   $("#tableDatas").DataTable({
            "lengthChange": false,
            "ordering": false,
            "processing": true,
            "searching": false,
            "serverSide": true,
            "deferRender": true,
            "ajax": {
                "url": url
            },
            "columns":columns,
            "language": {
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            },
            "drawCallback": function( settings ) {
                handlerInitIcheck();
                handlerInitIcheckAll();
            }

        });

       return _dataTables;
    };
    return{
        init:function () {
            handlerInitIcheck();
            handlerInitIcheckAll();
        },

        getICheck_all :function(){
            return iCheck_all;
        },

        deleteMulti:function (url) {
            handlerInitDeleteMulti(url);
        },
        dataTables:function (url,columns) {
           return  handlerInitDateTables(url,columns);
        }
    }

}();

$(document).ready(function () {
    app.init();
})