<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>     
 <!doctype html>
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/css/common.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css">
  <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.SuperSlide.js"></script>
<script type="text/javascript">
$(function(){
    $(".sideMenu").slide({
       titCell:"h3", 
       targetCell:"ul",
       defaultIndex:0, 
       effect:'slideDown', 
       delayTime:'500' , 
       trigger:'click', 
       triggerTime:'150', 
       defaultPlay:true, 
       returnDefault:false,
       easing:'easeInQuint',
       endFun:function(){
            scrollWW();
       }
     });
    $(window).resize(function() {
        scrollWW();
    });
});
function scrollWW(){
  if($(".side").height()<$(".sideMenu").height()){
     $(".scroll").show();
     var pos = $(".sideMenu ul:visible").position().top-38;
     $('.sideMenu').animate({top:-pos});
  }else{
     $(".scroll").hide();
     $('.sideMenu').animate({top:0});
     n=1;
  }
} 

var n=1;
function menuScroll(num){
var Scroll = $('.sideMenu');
var ScrollP = $('.sideMenu').position();
/*alert(n);
alert(ScrollP.top);*/
if(num==1){
   Scroll.animate({top:ScrollP.top-14});
   n = n+1;
}else{
  if (ScrollP.top > -14 && ScrollP.top != 0) { ScrollP.top = -14; }
  if (ScrollP.top<0) {
    Scroll.animate({top:14+ScrollP.top});
  }else{
    n=1;
  }
  if(n>1){
    n = n-1;
  }
}
}

//页面加载，异步查询字典数据
//页面加载函数就会执行：
$(function(){
	// 加载客户来源
	$.post("${pageContext.request.contextPath }/baseDict_findByTypeCode.action",{"dict_type_code":"002"},function(data){
		//遍历JOSN类型的数据
		$(data).each(function(i,n){
			$("#cust_source").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
		});
	},"json");
	
	// 加载客户所属行业
	$.post("${pageContext.request.contextPath }/baseDict_findByTypeCode.action",{"dict_type_code":"001"},function(data){
		//遍历JOSN类型的数据
		$(data).each(function(i,n){
			$("#cust_industry").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
		});
	},"json");
	
	// 加载客户级别
	$.post("${pageContext.request.contextPath }/baseDict_findByTypeCode.action",{"dict_type_code":"006"},function(data){
		//遍历JOSN类型的数据
		$(data).each(function(i,n){
			$("#cust_level").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
		});
	},"json");
});

  </script>
  <title>新增客户</title>
</head>
<body>
    <div class="top">
      <jsp:include page="../inc/top.jsp"></jsp:include>
      <div id="side_here">
        <div id="side_here_l" class="fl"></div>
        <div id="here_area" class="fl">当前位置：客户管理&gt;新增客户</div>
      </div>
    </div>
    
    <jsp:include page="../inc/left.jsp"></jsp:include>
    
    <!-- 中间框架 -->
    <div class="main" style="overflow-y:auto">
    <div class="container">
        <div class="main_top">
       <div id="forms" class="mt10">
        <div class="box">
          <div class="box_border">
            <div class="box_top"><b class="pl15">添加客户</b></div>
            <div class="box_center">
              <form action="${pageContext.request.contextPath }/customer_save.action" method="post" enctype="multipart/form-data" class="jqtransform">
               <table class="form_table pt15 pb15" width="100%" border="0" cellpadding="0" cellspacing="0">
                 <tr>
                  <td class="td_right">客户名称：</td>
                  <td class=""> 
                    <input type="text" name="cust_name" class="input-text lh30" size="40">
                  </td>
                  
                </tr>
                 <tr >
                  <td class="td_right">信息来源：</td>
                  <td class="">
 
                    <span class="fl">
                      <div class="select_border"> 
                        <div class="select_containers "> 
                        <select name="baseDictSource.dict_id" id="cust_source" class="select"> 
                        <option>-----</option> 
             
                        </select> 
                        </div> 
                      </div> 
                    </span>
                  </td>
                 </tr>
                <tr >
                  <td class="td_right">所属行业：</td>
                  <td class="">
 
                    <span class="fl">
                      <div class="select_border"> 
                        <div class="select_containers "> 
                        <select name="baseDictIndustry.dict_id" id="cust_industry" class="select"> 
                        <option>-----</option> 
                        </select> 
                        </div> 
                      </div> 
                    </span>
                  </td>
                 </tr>
                 <tr >
                  <td class="td_right">客户级别：</td>
                  <td class="">
 
                    <span class="fl">
                      <div class="select_border"> 
                        <div class="select_containers "> 
                        <select name="baseDictLevel.dict_id" id="cust_level" class="select"> 
                        <option>-----</option> 
                        </select> 
                        </div> 
                      </div> 
                    </span>
                  </td>
                 </tr>
                  <tr>
                  <td class="td_right">固定电话：</td>
                  <td class=""> 
                    <input type="text" name="cust_phone" class="input-text lh30" size="40">
                  </td>
                  
                </tr>
                  <tr>
                  <td class="td_right">移动电话：</td>
                  <td class=""> 
                    <input type="text" name="cust_mobile" class="input-text lh30" size="40">
                  </td>
                  
                </tr>
                 <tr>
                  <td class="td_right">相关文件：</td>
                  <td class=""><input type="file" name="file" class="input-text lh30" size="10"></td>
                 </tr>
                
                 <tr>
                   <td class="td_right">&nbsp;</td>
                   <td class="">
                     <input type="submit" name="button" class="btn btn82 btn_save2" value="保存"> 
                    <input type="reset" name="button" class="btn btn82 btn_res" value="重置"> 
                   </td>
                 </tr>
               </table>
               </form>
               <s:fielderror></s:fielderror>
            </div>
          </div>
        </div>
        </div>
        </div>
       
     </div>
    </div>
    
    
    <jsp:include page="../inc/bottom.jsp"></jsp:include>
    <div class="scroll">
          <a href="javascript:;" class="per" title="使用鼠标滚轴滚动侧栏" onclick="menuScroll(1);"></a>
          <a href="javascript:;" class="next" title="使用鼠标滚轴滚动侧栏" onclick="menuScroll(2);"></a>
    </div>
</body>

</html>
  