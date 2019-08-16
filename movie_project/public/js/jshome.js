$(document).ready(function () {

    $(".btn-play").modalVideo();

    // $('#option-tab li').click(function () {
    //     $('#option-tab li').removeClass("active-color");
    //     $(this).addClass("active-color");
    //     $('#tabmovie-slide div').removeClass('active-movie');
    //     var tabmovie = $(this).attr("tab-movie");
    //     $(tabmovie).addClass("active-movie");
    // })

    $('#frmLogin').submit(function (e) {
        e.preventDefault();
        console.log($(this).serialize());
        $.ajax({
            data : $(this).serialize(),
            type : $(this).attr("method"),
            url : "http://localhost:8080"+$(this).attr("action"),
            success : function (res) {
                console.log(res);
                // if(res){
                //     location.reload();
                // }else {
                //     alert("Sai email hoặc mật khẩu");
                // }
            },
            error : function (err) {
                console.log(err);
            }
        })
        $.ajax({
            data : null,
            type: "GET",
            url: "http://localhost:8080/api/userLogin",
            success : function (res) {
                console.log(res);
            }
        })
    })

    $('#dangxuat').click(function () {
        $.ajax({
            type : "GET",
            url : "http://localhost:8080/user/logout",
            success : function (res) {
                console.log(res);
            }
        })
    })




})