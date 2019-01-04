<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %> 
<!doctype html>
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="css/common.css">
  <link rel="stylesheet" href="css/style.css">
  <script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
  <script type="text/javascript" src="js/jquery.SuperSlide.js"></script>
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

  
  </script> 
  <title>后台首页</title>
</head>
<body>
    <div class="top">
      <jsp:include page="inc/top.jsp"></jsp:include>
      <div id="side_here">
        <div id="side_here_l" class="fl"></div>
        <div id="here_area" class="fl">当前位置：</div>
      </div>
    </div>
    <jsp:include page="inc/left.jsp"></jsp:include>
    <!-- 中间框架 -->
    <div class="main">
       <iframe name="right" id="rightMain" src="welcome.jsp" frameborder="no" scrolling="auto" width="100%" height="auto" allowtransparency="true"></iframe>
    </div>
    
    
    <jsp:include page="inc/bottom.jsp"></jsp:include>
    <div class="scroll">
          <a href="javascript:;" class="per" title="使用鼠标滚轴滚动侧栏" onclick="menuScroll(1);"></a>
          <a href="javascript:;" class="next" title="使用鼠标滚轴滚动侧栏" onclick="menuScroll(2);"></a>
    </div>
</body>

</html>
   