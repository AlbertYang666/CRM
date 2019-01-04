<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript">


//jquery 获取<ul> 点击的是那个<li>
$(function(){

	
	$('.sideMenu ul li a').each(function(index) {
		 
		if($(this).text()==$('title').text()){
	    	 $(this).parent().addClass('on'); 
	    	 
	     }else{
	    	 $(this).parent().removeClass('on'); 
	    	 $(this).parent().parent().prev().removeClass('on'); 
	     }
	  });

	});

</script>
<div class="side">
	<div class="sideMenu" style="margin: 0 auto">
		<h3>客户管理</h3>
		<ul>
			<li><a
				href="${pageContext.request.contextPath }/customer_saveUI.action">新增客户</a></li>
			<li><a
				href="${pageContext.request.contextPath }/customer_findAll.action">客户列表</a></li>

		</ul>
		<h3>联系人管理</h3>
		<ul>
			<li><a href="${pageContext.request.contextPath }/linkMan_saveUI.action">新增联系人</a></li>
			<li><a
				href="${pageContext.request.contextPath }/linkMan_findAll.action">联系人列表</a>
			</li>
		</ul>
		<h3>客户拜访管理</h3>
		<ul>
			<li><a
				href="${pageContext.request.contextPath }/saleVisit_saveUI.action">新增客户拜访</a></li>
			<li><a
				href="${pageContext.request.contextPath }/saleVisit_findAll.action">客户拜访列表</a></li>
		</ul>
		<h3>综合查询</h3>
		<ul>
			<li>客户信息查询</li>
			<li>联系人信息查询</li>
			<li>客户拜访记录查询</li>

		</ul>
		<h3>统计分析</h3>
		<ul>
			<li>客户行业统计</li>
			<li>客户来源统计</li>
		</ul>
		<h3>系统管理</h3>
		<ul>
			<li>角色管理</li>
			<li>用户管理</li>
			<li>数据字典</li>
		</ul>
	</div>
</div>