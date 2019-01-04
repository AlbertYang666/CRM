/**  
 
* @Title: BaseDictAction.java
 
* @Package com.albertyy.crm.web.action
 
* @Description: TODO
 
* @author yangxianyang  
 
* @date 2018年12月16日 下午7:54:21
 
* @version V1.0  
 
*/

package com.albertyy.crm.web.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.albertyy.crm.entity.BaseDict;
import com.albertyy.crm.service.BaseDictService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

/**  
*   
* 项目名称：CRM  
* 类名称：BaseDictAction  
* 类描述：字典的Action  
* 创建人：yangyangyang  
* 创建时间：2018年12月16日 下午7:54:21  
* 修改人：yangyangyang  
* 修改时间：2018年12月16日 下午7:54:21  
* 修改备注：  
* @version   
*   
*/

public class BaseDictAction extends ActionSupport implements ModelDriven<BaseDict> {
    //模型驱动使用的对象
	private BaseDict baseDict =new BaseDict();
	@Override
	public BaseDict getModel() {
		return baseDict;
	}
    //注入Service
	private BaseDictService baseDictService;
	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}
	
	//根据类型名称查询字典
	public String findByTypeCode(){
		//调用业务层查询方法
		List<BaseDict> list=baseDictService.findByTypeCode(baseDict.getDict_type_code());
		//使用jsonlib将list转换成JSON(常用工具jsonlib fastjson)
		/*
		 * JsonConfig:转JSON的配置对象
		 * JSONArray:将数组或者list集合转成JSON
		 * JSONObject:将对象或者map集合转成JSON
		 */
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.setExcludes(new String[]{"dict_sort","dict_enable","dict_memo"});
		JSONArray jsonArray=JSONArray.fromObject(list,jsonConfig);
		//System.out.println(jsonArray.toString());
		//将JSON数据传到页面
		try {
			ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
			ServletActionContext.getResponse().getWriter().println(jsonArray.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return NONE;
	}
}
