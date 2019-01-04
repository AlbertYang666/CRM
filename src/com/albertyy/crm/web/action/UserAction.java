/**  
 
* @Title: UserAction.java
 
* @Package com.albertyy.crm.web.action
 
* @Description: TODO
 
* @author yangxianyang  
 
* @date 2018年12月13日 上午11:42:41
 
* @version V1.0  
 
*/

package com.albertyy.crm.web.action;

import com.albertyy.crm.entity.User;
import com.albertyy.crm.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 *        项目名称：CRM   类名称：UserAction   类描述： 用户管理Action  创建人：yangyangyang  
 * 创建时间：2018年12月13日 上午11:42:41   修改人：yangyangyang   修改时间：2018年12月13日
 * 上午11:42:41   修改备注：   @version       
 */

public class UserAction extends ActionSupport implements ModelDriven<User> {
	// 模型驱动使用的对象
	private User user = new User();

	@Override
	public User getModel() {
		return user;
	}

	// 注入Service
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	// 验证码
	private String verify;

	public void setVerify(String verify) {
		this.verify = verify;
	}

	/*
	 * 用户注册的方法
	 */
	public String register() {
		// 比较验证码
		String serverCode = (String) ActionContext.getContext().getSession().get("SESSION_SECURITY_CODE");
		if (!serverCode.equals(verify)) {
			// 注册失败，保存错误信息
			this.addActionError("验证码错误！");
			return "register";
		}
		userService.register(user);
		return LOGIN;
	}

	/*
	 * 用户登陆的方法
	 */
	public String login() {
		User loginuser = userService.login(user);
		// 比较验证码
		String serverCode = (String) ActionContext.getContext().getSession().get("SESSION_SECURITY_CODE");
		if (!serverCode.equals(verify)) {
			// 登陆失败，保存错误信息
			this.addActionError("验证码错误！");
			return LOGIN;
		}
		if (loginuser == null) {
			// 登陆失败，保存错误信息
			this.addActionError("用户名或密码错误！");
			return LOGIN;
		} else {
			// 登陆成功，保存登陆的用户
			ActionContext.getContext().getSession().put("loginuser", loginuser);
			return SUCCESS;
		}

	}

	// 退出登陆
	public String exit() {
		ActionContext.getContext().getSession().clear();
		return "exitSuccess";
	}
}
