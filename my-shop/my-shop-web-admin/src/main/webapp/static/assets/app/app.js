/**
 * 函数对象
 */
var app = function () {

    var iCheck_master;
    var iCheck_all;
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
    }
    return{
        init:function () {
            handlerInitIcheck();
            handlerInitIcheckAll();
        }
    }

}();

$(document).ready(function () {
    app.init();
})