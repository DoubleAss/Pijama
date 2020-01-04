var context = window.location.pathname.substring(0, window.location.pathname.indexOf("/",2)); 
var contextPath =window.location.protocol+"//"+ window.location.host + context;
//	
////in ra màn hình để test
////alert(contextPath);
//
//$(document).ready(function(){
//
//  $(".submenu > a").click(function(e) {
//    e.preventDefault();
//    var $li = $(this).parent("li");
//    var $ul = $(this).next("ul");
//
//    if($li.hasClass("open")) {
//      $ul.slideUp(350);
//      $li.removeClass("open");
//    } else {
//      $(".nav > li > ul").slideUp(350);
//      $(".nav > li").removeClass("open");
//      $ul.slideDown(350);
//      $li.addClass("open");
//    }
//  });
//  
//  $("#formCat").validate({
//      rules: {
//      	cname: "required",
//      },
//      messages: {
//      	cname: "Vui lòng nhập tên danh mục!",
//      },
//  });
//  
//  $("#formColor").validate({
//      rules: {
//      	color_name: "required",
//      	color_code: "required",
//      },
//      messages: {
//    	  color_name: "Vui lòng nhập tên màu!",
//    	  color_code: "Vui lòng nhập mã màu (search google)!",
//      },
//  });
//  
//  $("#formItem").validate({
//      rules: {
//      	item_name: "required",
//      	ram: "required",
//      	old_cost: "required",
//      	description: "required",
//      	detail_text: "required",
//      },
//      messages: {
//      	item_name: "Vui lòng nhập tên danh mục!",
//      	ram: "Vui lòng nhập dung lượng ram!",
//      	old_cost: "Vui lòng nhập giá gốc!",
//      	description: "Vui lòng nhập mô tả!",
//      	detail_text: "Vui lòng nhập nội dung tin!",
//      },
//  });
//  
//  $("#formuser").validate({
//      rules: {
//    	fullname: "required",  
//    	username: {
//    		required: true,
//    		minlength: 6,
//    		maxlength: 20,
//    	},
//    	password: {
//      		required: true,
//    		minlength: 6,
//      	},
//      },
//      messages: {
//    	fullname: "Vui lòng nhập họ tên!",  
//      	username: {
//      		required: "Vui lòng nhập tên đăng nhập!",
//      		minlength: "Tên đăng nhập phải có ít nhất 6 ký tự!",
//      		maxlength: "Tên đăng nhập có nhiều nhất 20 ký tự!",
//      	},
//      	password: {
//      		required: "Vui lòng nhập mật khẩu!",
//      		minlength: "Mật khẩu phải có ít nhất 6 ký tự!",
//    	},
//      },
//  });
//  
//});
//
//function getStatusForUser(id, status) {
//    $.ajax({
//        url: contextPath+"/admin/user/activeuser",
//        type: 'POST',
//        data: {
//            aid: id,
//            astatus : status,
//        },
//        success: function(data){
//            $("#ketqua-"+id).html(data);
//        },
//        error: function (){
//            alert('Có lỗi xảy ra!');
//        }
//    });
//    return false;
//};
//
//function getStatusForItem(id, status) {
//    $.ajax({
//    	url : contextPath+"/admin/item/activeitem",
//        type: 'POST',
//        data: {
//            aid: id,
//            astatus : status,
//        },
//        success: function(data){
//            $("#ketqua-"+id).html(data);
//        },
//        error: function (){
//            alert('Có lỗi xảy ra!');
//        }
//    });
//    return false;
//};

function getStatusForContact(id, status) {
    $.ajax({
        url: contextPath+"/contact/activeContact",
        type: 'POST',
        data: {
            aid: id,
            astatus : status,
        },
        success: function(data){
            $("#ketqua-"+id).html(data);
        },
        error: function (){
            alert('Có lỗi xảy ra!');
        }
    });
    return false;
};