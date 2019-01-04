<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!doctype html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/easydialog.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/common.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/main.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/easydialog.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.SuperSlide.js"></script>

<script type="text/javascript">
	$(function() {
		$(".sideMenu").slide({
			titCell : "h3",
			targetCell : "ul",
			defaultIndex : 2,
			effect : 'slideDown',
			delayTime : '500',
			trigger : 'click',
			triggerTime : '150',
			defaultPlay : true,
			returnDefault : false,
			easing : 'easeInQuint',
			endFun : function() {
				scrollWW();
			}
		});
		$(window).resize(function() {
			scrollWW();
		});
	});
	function scrollWW() {
		if ($(".side").height() < $(".sideMenu").height()) {
			$(".scroll").show();
			var pos = $(".sideMenu ul:visible").position().top - 38;
			$('.sideMenu').animate({
				top : -pos
			});
		} else {
			$(".scroll").hide();
			$('.sideMenu').animate({
				top : 0
			});
			n = 1;
		}
	}

	var n = 1;
	function menuScroll(num) {
		var Scroll = $('.sideMenu');
		var ScrollP = $('.sideMenu').position();
		/*alert(n);
		alert(ScrollP.top);*/
		if (num == 1) {
			Scroll.animate({
				top : ScrollP.top - 14
			});
			n = n + 1;
		} else {
			if (ScrollP.top > -14 && ScrollP.top != 0) {
				ScrollP.top = -14;
			}
			if (ScrollP.top < 0) {
				Scroll.animate({
					top : 14 + ScrollP.top
				});
			} else {
				n = 1;
			}
			if (n > 1) {
				n = n - 1;
			}
		}
	}

	//提交分页的方法
	function to_page(page) {
		if (page) {
			$("#page").val(page);
		}
		document.customerForm.submit();
	}
	//删除联系人弹窗
	function toDelete(id) {

		var btnFn = function() {
			location.href = "${pageContext.request.contextPath}/linkMan_delete.action?lkm_id="
					+ id;
			return false;
		};

		easyDialog.open({
			container : {
				header : '确认删除',
				content : '您确定要删除该条数据吗？',
				yesFn : btnFn,
				noFn : true
			}
		});
	};
	// 修改联系人弹窗
	function toUpdate(id) {
		linkManInfo(id);

		var content = $('#updateBox').html();

		var btnFn = function() {
			$("input#updateForm").click();
			return false;
		};

		easyDialog.open({
			container : {
				header : '修改用户信息',
				content : content,
				yesFn : btnFn,
				noFn : true
			}
		});
		// $('.easyDialog_wrapper').css('width','400px');
		$('.easyDialog_text').css('height', '350px');

	};
	//异步请求加载要修改的联系人的信息
	function linkManInfo(id) {
		// 加载联系人信息
		$.post("${pageContext.request.contextPath }/linkMan_edit.action", {
			"lkm_id" : id
		}, function(data) {
			//遍历JOSN类型的数据
			$.each(data, function(name, value) {
				if (name == "lkm_gender") {
					//回显性别
					$("input:radio[name=" + name + "][value=" + value + "]")
							.attr("checked", true);
				}
				$("select#" + name + " option[value='" + value + "']").prop(
						"selected", "selected");
				$("input#" + name).val(value);
				$("textarea#" + name).val(value);

			});

		}, "json");
	}
	//页面加载，异步查询客户
	//页面加载函数就会执行：
	$(function() {
		// 加载客户
		$
				.post(
						"${pageContext.request.contextPath }/linkMan_findByCustomer.action",
						{
							"" : ""
						}, function(data) {
							//遍历JOSN类型的数据
							$(data).each(
									function(i, n) {
										$("select#lkm_cust").append(
												"<option value='"+n.cust_id+"'>"
														+ n.cust_name
														+ "</option>");
									});
						}, "json");

	});
</script>
<title>客户拜访列表</title>
</head>
<body>
	<div class="top">
		<jsp:include page="../inc/top.jsp"></jsp:include>
		<div id="side_here">
			<div id="side_here_l" class="fl"></div>
			<div id="here_area" class="fl">当前位置：客户拜访管理&gt;客户拜访列表</div>
		</div>
	</div>

	<jsp:include page="../inc/left.jsp"></jsp:include>

	<!-- 中间框架 -->
	<div class="main" style="overflow-y: auto">

		<div class="container">

			<form name="customerForm"
				action="${pageContext.request.contextPath }/saleVisit_findAll.action"
				method="post">

				<div id="search_bar" class="mt10">
					<div class="box">
						<div class="box_border">
							<div class="box_top">
								<b class="pl15">搜索</b>
							</div>
							<div class="box_center pt10 pb10">
								<table class="form_table" cellspacing="0" cellpadding="0"
									border="0">
									<tbody>
										<tr>
											<td>拜访时间从:</td>
											<td><input type="date" name="visit_time"
												value="<s:date name="visit_time" format="yyyy-MM-dd"/>"
												class="input-text lh25" size="10"></td>
											<td>到:</td>
											<td><input type="date" name="visit_endtime"
												value="<s:date name="visit_endtime" format="yyyy-MM-dd"/>"
												class="input-text lh25" size="10"></td>



											<td><input type="submit" name="button"
												class="btn btn82 btn_search" value="查询"></td>
										</tr>

									</tbody>
								</table>
							</div>

						</div>
					</div>
				</div>

				<div id="table" class="mt10">
					<div class="box span10 oh">
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							class="list_table">
							<tr>
								<th width="100">客户名称</th>
								<th width="100">负责人名称</th>
								<th width="100">拜访时间</th>
								<th width="100">拜访地点</th>
								<th width="100">拜访详情</th>
								<th width="100">下次拜访时间</th>
								<th width="150">操作</th>
							</tr>
							<s:iterator value="list">

								<tr class="tr">
									<td><s:property value="customer.cust_name" /></td>
									<td><s:property value="user.user_name" /></td>
									<td><s:date name="visit_time" format="yyyy-MM-dd"/></td>
									<td><s:property value="visit_addr" /></td>
									<td><div style="height: 30px; overflow-y: auto;">
											<s:property value="visit_detail" />
										</div></td>
									<td><s:date name="visit_nexttime" format="yyyy-MM-dd"/></td>
									<td><input type="button" name="button"
										class="btn btn82 btn_add" id="modifyBtn"
										onclick="toUpdate('<s:property value="lkm_id"/>')" value="修改">
										<input type="button" name="button" class="btn btn82 btn_del"
										onclick="toDelete('<s:property value="lkm_id"/>')" value="删除"></td>

								</tr>
							</s:iterator>

						</table>
						<div class="page mt10">

							<div class="pagination">
								<ul>
									<li class="disabled"><span> 共<s:property
												value="totalCount" />条记录， 共 <s:property value="totalPage" />页
									</span></li>
									<li><span> 每页显示记录数： <select name="pageSize"
											onchange="to_page()">
												<option value="5" <s:if test="pageSize==5">selected</s:if>>5条</option>
												<option value="10" <s:if test="pageSize==10">selected</s:if>>10条</option>
												<option value="20" <s:if test="pageSize==20">selected</s:if>>20条</option>
										</select>

									</span></li>


									<s:if test="page!=1">
										<li><a href="javascript:to_page(1)">首页</a></li>
										<li><a
											href="javascript:to_page(<s:property value="page-1" />)">上一页</a></li>
									</s:if>

									<s:iterator var="i" begin="1" end="totalPage">
										<s:if test="#i==page">
											<li class="active"><span><s:property value="#i" />
											</span></li>
										</s:if>
										<s:else>
											<li><a
												href="javascript:to_page(<s:property value="#i" />)"><s:property
														value="#i" /></a></li>
										</s:else>
									</s:iterator>

									<s:if test="page!=totalPage">
										<li><a
											href="javascript:to_page(<s:property value="page+1" />)">下一页</a></li>
										<li><a
											href="javascript:to_page(<s:property value="totalPage" />)">末页</a></li>
									</s:if>
									<li>到第 <input class="input-text lh25" type="text"
										id="page" name="page" size="2" height="10px" />页 <input
										class="ext_btn" type="button" value="GO" onclick="to_page()" />

									</li>
								</ul>
							</div>
						</div>
			</form>


		</div>
	</div>




	<!-- 修改联系人窗口 -->
	<div id="updateBox" class="update" style="display: none;">


		<form
			action="${pageContext.request.contextPath }/linkMan_update.action"
			method="post" enctype="multipart/form-data" class="jqtransform">
			<input type="hidden" name="lkm_id" id="lkm_id"> <input
				type="hidden" name="cust_image" id="cust_image">
			<table class="form_table pt15 pb15" width="100%" border="0"
				cellpadding="0" cellspacing="0">
				<tr>
					<td class="td_right">所属客户：</td>
					<td class=""><span class="fl">
							<div class="select_border">
								<div class="select_containers ">
									<select name="customer.cust_id" id="lkm_cust" class="select">
										<option value="">请选择</option>
									</select>
								</div>
							</div>
					</span></td>
				</tr>

				<tr>
					<td class="td_right">联系人名称：</td>
					<td class=""><input type="text" name="lkm_name" id="lkm_name"
						class="input-text lh30" required="required"></td>

				</tr>
				<tr>
					<td class="td_right">联系人性别：</td>
					<td class=""><input type="radio" name="lkm_gender" value="1">
						男 <input type="radio" name="lkm_gender" value="2">女</td>
				</tr>
				<tr>
					<td class="td_right">联系人电话：</td>
					<td class=""><input type="number" name="lkm_phone"
						id="lkm_phone" class="input-text lh30"></td>

				</tr>
				<tr>
					<td class="td_right">联系人手机：</td>
					<td class=""><input type="number" name="lkm_mobile"
						id="lkm_mobile" class="input-text lh30"></td>

				</tr>
				<tr>
					<td class="td_right">联系人邮箱：</td>
					<td class=""><input type="email" name="lkm_email"
						id="lkm_email" class="input-text lh30"></td>

				</tr>
				<tr>
					<td class="td_right">联系人QQ：</td>
					<td class=""><input type="number" name="lkm_qq" id="lkm_qq"
						class="input-text lh30"></td>

				</tr>
				<tr>
					<td class="td_right">联系人职位：</td>
					<td class=""><input type="text" name="lkm_position"
						id="lkm_position" class="input-text lh30"></td>

				</tr>
				<tr>
					<td class="td_right">联系人备注：</td>
					<td class=""><textarea name="lkm_memo" id="lkm_memo" cols="30"
							rows="10" class="textarea" style="width: 200px; height: 93px;"></textarea>
					</td>
				</tr>




				<tr>
					<td class="td_right">&nbsp;</td>
					<td class=""><input id="updateForm" type="submit"
						name="button" class="btn btn82 btn_save2" value="保存"> <input
						type="reset" name="button" class="btn btn82 btn_res" value="重置"></td>
				</tr>
			</table>
		</form>

	</div>

	</div>
	</div>
	<jsp:include page="../inc/bottom.jsp"></jsp:include>
	<div class="scroll">
		<a href="javascript:;" class="per" title="使用鼠标滚轴滚动侧栏"
			onclick="menuScroll(1);"></a> <a href="javascript:;" class="next"
			title="使用鼠标滚轴滚动侧栏" onclick="menuScroll(2);"></a>
	</div>

</body>

</html>
