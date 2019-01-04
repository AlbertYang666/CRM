/*
 *客户查询页面js
 */

//删除弹窗
function toDelete(id) {

	var btnFn = function() {
		location.href = "${pageContext.request.contextPath}/customer_delete.action?cust_id="
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

// 修改弹窗
function toUpdate(id) {
	customerInfo(id);
	
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
//异步请求加载要修改的客户的信息
function customerInfo(id){
	// 加载客户信息
	$.post("${pageContext.request.contextPath }/customer_edit.action",{"cust_id":id},function(data){
		//遍历JOSN类型的数据
		$.each(data,function(name,value){
			
			$("select#"+name+" option[value='"+value+"']").prop("selected","selected");
			$("input#"+name).val(value);
			
		});
		
	},"json");
}

//页面加载，异步查询字典数据
//页面加载函数就会执行：
$(function(){
	// 加载客户来源
	$.post("${pageContext.request.contextPath }/baseDict_findByTypeCode.action",{"dict_type_code":"002"},function(data){
		//遍历JOSN类型的数据
		$(data).each(function(i,n){
			$("select#cust_source").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
		});
	},"json");
	
	// 加载客户所属行业
	$.post("${pageContext.request.contextPath }/baseDict_findByTypeCode.action",{"dict_type_code":"001"},function(data){
		//遍历JOSN类型的数据
		$(data).each(function(i,n){
			$("select#cust_industry").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
		});
	},"json");
	
	// 加载客户级别
	$.post("${pageContext.request.contextPath }/baseDict_findByTypeCode.action",{"dict_type_code":"006"},function(data){
		//遍历JOSN类型的数据
		$(data).each(function(i,n){
			$("select#cust_level").append("<option value='"+n.dict_id+"'>"+n.dict_item_name+"</option>");
		});
	},"json");
});

