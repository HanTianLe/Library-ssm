function uN() {
    if ($("#username").val()==""){
        alert("登录名不为空")
    }
}

function N() {
    if ($("#name").val()==""){
        alert("用户名不为空")
    }
}

$(function() {
    $(".search input[name='confirm']").on("blur",function() {

        let password =  $(".search input[name='password']").val();
        let confirm = $(".search input[name='confirm']").val();

        if (password != '' && confirm != '') {
            if (confirm != password) {
                alert("两次密码输入不相同！")
            }
        }else{
            alert("密码不能为空！")
        }
    })

})
