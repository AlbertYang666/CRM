/**  
 
* @Title: SaleVisitAction.java
 
* @Package com.albertyy.crm.web.action
 
* @Description: TODO
 
* @author yangxianyang  
 
* @date 2019年1月1日 下午5:20:03
 
* @version V1.0  
 
*/

package com.albertyy.crm.web.action;

import java.sql.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.albertyy.crm.entity.Customer;
import com.albertyy.crm.entity.SaleVisit;
import com.albertyy.crm.entity.User;
import com.albertyy.crm.service.CustomerService;
import com.albertyy.crm.service.SaleVisitService;
import com.albertyy.crm.service.UserService;
import com.albertyy.crm.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 *        项目名称：CRM   类名称：SaleVisitAction   类描述：  客户拜访Action 创建人：yangyangyang  
 * 创建时间：2019年1月1日 下午5:20:03   修改人：yangyangyang   修改时间：2019年1月1日 下午5:20:03  
 * 修改备注：   @version       
 */

public class SaleVisitAction extends ActionSupport implements ModelDriven<SaleVisit> {
	// 模型驱动使用的对象
	private SaleVisit saleVisit = new SaleVisit();

	public SaleVisit getModel() {
		return saleVisit;
	}

	// 注入Service
	private SaleVisitService saleVisitService;

	public void setSaleVisitService(SaleVisitService saleVisitService) {
		this.saleVisitService = saleVisitService;
	}

	private CustomerService customerService;
	private UserService userService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
     //结束时间
	private Date visit_endtime;
	
	public Date getVisit_endtime() {
		return visit_endtime;
	}

	public void setVisit_endtime(Date visit_endtime) {
		this.visit_endtime = visit_endtime;
	}

	// 接收分页数据
	private Integer page = 1;
	private Integer pageSize = 5;

	public void setPage(Integer page) {
		if (page == null) {
			page = 1;
		}
		this.page = page;
	}

	public void setPageSize(Integer pageSize) {
		if (pageSize == null) {
			pageSize = 5;
		}
		this.pageSize = pageSize;
	}

	// 分页查询客户拜访记录的方法
	public String findAll() {
		// 创建离线条件查询对象
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(SaleVisit.class);
		// 设置条件
		if (saleVisit.getVisit_time() != null) {
			detachedCriteria.add(Restrictions.ge("visit_time", saleVisit.getVisit_time()));
		}
		// 设置条件
		if (visit_endtime != null) {
			detachedCriteria.add(Restrictions.le("visit_time", visit_endtime));
		}
		PageBean<SaleVisit> pageBean = saleVisitService.findByPage(detachedCriteria, page, pageSize);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}

	// 跳转到添加页面的方法
	public String saveUI() {
		// 查询客户和负责人
		List<Customer> customerlist = customerService.findAll();
		List<User> userlist = userService.findAll();
		ActionContext.getContext().getValueStack().set("customerlist", customerlist);
		ActionContext.getContext().getValueStack().set("userlist", userlist);
		return "saveUI";
	}

	// 保存拜访记录
	public String save() {
		saleVisitService.save(saleVisit);

		// 跳转到列表页面
		findAll();
		return "saveSuccess";
	}
}
