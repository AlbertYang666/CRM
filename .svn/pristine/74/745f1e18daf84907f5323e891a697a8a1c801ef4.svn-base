package com.albertyy.crm.web.intercept;

import org.apache.struts2.ServletActionContext;

import com.albertyy.crm.entity.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
/*
 * 拦截器类
 */
public class PrivilegeInterceptor extends MethodFilterInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//判断session中是否有登陆用户
		User loginUser=(User) ServletActionContext.getRequest().getSession().getAttribute("loginuser");
		if(loginUser==null){
			//跳转到登陆页面
			ActionSupport actionSupport=(ActionSupport) invocation.getAction();
			actionSupport.addActionError("您还没有登陆，请登陆！");
			return actionSupport.LOGIN;
		}else{
			//已经登陆
			return invocation.invoke();
		}
		
	}

}
