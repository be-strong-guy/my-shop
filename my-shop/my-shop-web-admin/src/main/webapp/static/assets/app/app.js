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
                            if(e.status==200){
                                //当重新刷新时候，绑定的click方法也会消失，否则下次点击确认会删除多次
                                window.location.reload();
                            }else {
                                //先解绑它的方法
                                $("#myModal").unbind("click");
                                //再重新绑定方法
                                $("#myModal").bind('click',function () {
                                    $("#modal-default").modal("hide");
                                });
                                //弹出模态框提示失败
                                $("#modal-message").html(e.message);
                                $("#modal-default").modal("show");

                                //下面这个方式不太行，因为$("#myModal")绑定的方法不会消失，会执行很多次,会有问题
                                /*ids=new Array();
                                $("#modal-message").html(e.message);
                                $("#modal-default").modal("show");*/
                            }

                        }
                    })
                },500)
            }
        }
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
        }
    }

}();

$(document).ready(function () {
    app.init();
})