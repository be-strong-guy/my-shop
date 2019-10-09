/**
 * 函数对象
 */
var App = function () {
    var iCheck_master ;
    var iCheckAll;
    var handlerInitICheck = function () {
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass   : 'iradio_minimal-blue'
        });

        iCheck_master = $('input[type="checkbox"].minimal.iCheck_master');
        iCheckAll = $('input[type="checkbox"].minimal');
    };

    var handlerInitIcheckAll = function () {
        iCheck_master.on("ifClicked",function (e) {
            //true代表不选中，原本是选中状态，返回true，但是又点击一下就是取消了选中状态
            if(e.target.checked){
                iCheckAll.iCheck("uncheck");
            }else {
                //代表选中，原本是不选中状态，返回false，又点击一下就是选中了
                iCheckAll.iCheck("check");
            }
        }
        )
    };
    return{
        init:function () {
            handlerInitICheck();
            handlerInitIcheckAll();
        }
    }
}();

$(document).ready(function () {
    App.init();
});