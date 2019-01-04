<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!doctype html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/common.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/css/main.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.SuperSlide.js"></script>
<script type="text/javascript">
	$(function() {
		$(".sideMenu").slide({
			titCell : "h3",
			targetCell : "ul",
			defaultIndex : 1,
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
</script>
<title>新增联系人</title>
</head>
<body>
	<div class="top">
		<jsp:include page="../inc/top.jsp"></jsp:include>
		<div id="side_here">
			<div id="side_here_l" class="fl"></div>
			<div id="here_area" class="fl">当前位置：联系人管理&gt;新增联系人</div>
		</div>
	</div>

	<jsp:include page="../inc/left.jsp"></jsp:include>

	<!-- 中间框架 -->
	<div class="main" style="overflow-y: auto">
		<div class="container">
			<div class="main_top">
				<div id="forms" class="mt10">
					<div class="box">
						<div class="box_border">
							<div class="box_top">
								<b class="pl15">添加联系人</b>
							</div>
							<div class="box_center">
								<form
									action="${pageContext.request.contextPath }/linkMan_save.action"
									method="post" class="jqtransform">
									<table class="form_table pt15 pb15" width="100%" border="0"
										cellpadding="0" cellspacing="0">
										<tr>
											<td class="td_right">所属客户：</td>
											<td class=""><span class="fl">
													<div class="select_border">
														<div class="select_containers ">
															<select name="customer.cust_id" id="cust_source"
																class="select">
																<option value="">请选择</option>
																<s:iterator value="list">
																	<option value='<s:property value="cust_id"/>'><s:property
																			value="cust_name" /></option>
																</s:iterator>
															</select>
														</div>
													</div>
											</span></td>
										</tr>
										
										<tr>
											<td class="td_right">联系人名称：</td>
											<td class=""><input type="text" name="lkm_name"
												class="input-text lh30"  required="required"></td>

										</tr>
										<tr>
											<td class="td_right">联系人性别：</td>
											<td class=""><input type="radio" name="lkm_gender" value="1">
												男 <input type="radio" name="lkm_gender" value="2">女</td>
										</tr>
										<tr>
											<td class="td_right">联系人电话：</td>
											<td class=""><input type="number" name="lkm_phone"
												class="input-text lh30" ></td>

										</tr>
										<tr>
											<td class="td_right">联系人手机：</td>
											<td class=""><input type="number" name="lkm_mobile"
												class="input-text lh30" ></td>

										</tr>
										<tr>
											<td class="td_right">联系人邮箱：</td>
											<td class=""><input type="email" name="lkm_email"
												class="input-text lh30" ></td>

										</tr>
										<tr>
											<td class="td_right">联系人QQ：</td>
											<td class=""><input type="number" name="lkm_qq"
												class="input-text lh30" ></td>

										</tr>
										<tr>
											<td class="td_right">联系人职位：</td>
											<td class=""><input type="text" name="lkm_position"
												class="input-text lh30" ></td>

										</tr>
										<tr>
											<td class="td_right">联系人备注：</td>
											<td class=""><textarea name="lkm_memo" id="" cols="30" rows="10"
													class="textarea" style="width: 362px; height: 93px;"></textarea>
											</td>
										</tr>




										<tr>
											<td class="td_right">&nbsp;</td>
											<td class=""><input type="submit" name="button"
												class="btn btn82 btn_save2" value="保存"> <input
												type="reset" name="button" class="btn btn82 btn_res"
												value="重置"></td>
										</tr>
									</table>
								</form>
							</div>
						</div>
					</div>
				</div>
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