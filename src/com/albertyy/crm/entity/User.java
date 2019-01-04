/**  
 
* @Title: User.java
 
* @Package com.albertyy.crm.entity
 
* @Description: TODO
 
* @author yangxianyang  
 
* @date 2018年12月13日 上午11:40:10
 
* @version V1.0  
 
*/

package com.albertyy.crm.entity;

/**
 *        项目名称：CRM   类名称：User   类描述： 用户实体类  创建人：yangyangyang   创建时间：2018年12月13日
 * 上午11:40:10   修改人：yangyangyang   修改时间：2018年12月13日 上午11:40:10  
 * 修改备注：   @version       
 */
/*
 * CREATE TABLE `sys_user` ( `user_id` bigint(32) NOT NULL AUTO_INCREMENT
 * COMMENT '用户id', `user_code` varchar(32) NOT NULL COMMENT '用户账号', `user_name`
 * varchar(64) NOT NULL COMMENT '用户名称', `user_password` varchar(32) NOT NULL
 * COMMENT '用户密码', `user_state` char(1) NOT NULL COMMENT '1:正常,0:暂停', PRIMARY
 * KEY (`user_id`) ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
 */
public class User {
	private Long user_id;
	private String user_code;
	private String user_name;
	private String user_password;
	private String user_state;
	
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getUser_code() {
		return user_code;
	}
	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_state() {
		return user_state;
	}
	public void setUser_state(String user_state) {
		this.user_state = user_state;
	}
}
