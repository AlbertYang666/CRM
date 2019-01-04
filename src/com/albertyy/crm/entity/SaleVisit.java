/**  
 
* @Title: SaleVisit.java
 
* @Package com.albertyy.crm.entity
 
* @Description: TODO
 
* @author yangxianyang  
 
* @date 2019年1月1日 下午4:32:53
 
* @version V1.0  
 
*/

package com.albertyy.crm.entity;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *        项目名称：CRM   类名称：SaleVisit   类描述： 客户拜访实体类  创建人：yangyangyang  
 * 创建时间：2019年1月1日 下午4:32:53   修改人：yangyangyang   修改时间：2019年1月1日 下午4:32:53  
 * 修改备注：   @version       
 */

public class SaleVisit {
	private String visit_id;
	private Timestamp visit_time;
	private String visit_addr;
	private String visit_detail;
	private Date visit_nexttime;
	// 拜访记录关联的客户对象
	private Customer customer;
	// 拜访记录关联的用户对象
	private User user;

	public String getVisit_id() {
		return visit_id;
	}

	public void setVisit_id(String visit_id) {
		this.visit_id = visit_id;
	}

	public Timestamp getVisit_time() {
		return visit_time;
	}

	public void setVisit_time(Timestamp visit_time) {
		this.visit_time = visit_time;
	}

	public String getVisit_addr() {
		return visit_addr;
	}

	public void setVisit_addr(String visit_addr) {
		this.visit_addr = visit_addr;
	}

	public String getVisit_detail() {
		return visit_detail;
	}

	public void setVisit_detail(String visit_detail) {
		this.visit_detail = visit_detail;
	}

	public Date getVisit_nexttime() {
		return visit_nexttime;
	}

	public void setVisit_nexttime(Date visit_nexttime) {
		this.visit_nexttime = visit_nexttime;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
