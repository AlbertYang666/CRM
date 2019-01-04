/**  
 
* @Title: LinkManAction.java
 
* @Package com.albertyy.crm.web.action
 
* @Description: TODO
 
* @author yangxianyang  
 
* @date 2018年12月19日 下午5:29:26
 
* @version V1.0  
 
*/

package com.albertyy.crm.web.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;


import com.albertyy.crm.entity.Customer;
import com.albertyy.crm.entity.LinkMan;
import com.albertyy.crm.service.CustomerService;
import com.albertyy.crm.service.LinkManService;
import com.albertyy.crm.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/**
 *        项目名称：CRM   类名称：LinkManAction   类描述：  联系人管理Action 创建人：yangyangyang  
 * 创建时间：2018年12月19日 下午5:29:26   修改人：yangyangyang   修改时间：2018年12月19日 下午5:29:26  
 * 修改备注：   @version       
 */

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {
	// 模型驱动对象
	LinkMan linkMan = new LinkMan();

	@Override
	public LinkMan getModel() {
		return linkMan;
	}

	// 注入Service
	private LinkManService linkManService;

	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}

	// 注入业务层的Action
	public CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	// 接收当前页数和每页显示记录数
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

	// 查询所有联系人的方法
	public String findAll() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LinkMan.class);
		// 设置条件
        if(linkMan.getLkm_name()!=null){
        	//设置按名称查找的条件
        	detachedCriteria.add(Restrictions.like("lkm_name", "%"+linkMan.getLkm_name()+"%"));
        }
        //设置性别条件
        if(linkMan.getLkm_gender()!=null&&!linkMan.getLkm_gender().trim().equals("")){
        	//设置按名称查找的条件
        	detachedCriteria.add(Restrictions.like("lkm_gender", "%"+linkMan.getLkm_gender()+"%"));
        }
		// 调用业务层查询
		PageBean<LinkMan> pageBean = linkManService.findByPage(detachedCriteria, page, pageSize);
		ActionContext.getContext().getValueStack().push(pageBean);

		return "findAll";
	}

	// 跳转到添加页面的方法
	public String saveUI() {
		// 查询客户
		List<Customer> list = customerService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "saveUI";
	}

	// 保存联系人的方法
	public String save() {
		// 调用业务层
		linkManService.save(linkMan);
		// 跳转到查询页面
		findAll();
		return "saveSuccess";
	}

	// 删除联系人
	public String delete() {
		// 调用业务层查找联系人
		linkMan = linkManService.findById(linkMan.getLkm_id());
		// 调用业务层删除联系人
		linkManService.delete(linkMan);
		// 跳转到查询页面
		findAll();
		return "deleteSuccess";
	}

	// 联系人修改异步查询信息的方法
	public String edit() {
		linkMan = linkManService.findById(linkMan.getLkm_id());
		// 把需要传送的数据封装成map集合
		Map map = new TreeMap();
		map.put("lkm_id", linkMan.getLkm_id());
		map.put("lkm_name", linkMan.getLkm_name());
		map.put("lkm_cust", linkMan.getCustomer().getCust_id());
		map.put("lkm_gender", linkMan.getLkm_gender());
		map.put("lkm_phone", linkMan.getLkm_phone());
		map.put("lkm_mobile", linkMan.getLkm_mobile());
		map.put("lkm_email", linkMan.getLkm_email());
		map.put("lkm_qq", linkMan.getLkm_qq());
		map.put("lkm_position", linkMan.getLkm_position());
		map.put("lkm_memo", linkMan.getLkm_memo());

		// 转成json
		JSONObject jsonObject = JSONObject.fromObject(map);

		// System.out.println(jsonObject);
		// 将JSON数据传到页面
		try {
			ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
			ServletActionContext.getResponse().getWriter().println(jsonObject.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return NONE;
	}

	// 联系人修改的方法
	public String update() {
		// 调用业务层
		linkManService.update(linkMan);
		return "updateSuccess";
	}

	// 联系人修改异步加载客户信息
	public String findByCustomer() {
		// 调用业务层查询方法
		List<Customer> cust_list = customerService.findAll();
		List<Customer> list=new ArrayList<Customer>();
		for (Customer customer : cust_list) {
			Customer c =new Customer();
			c.setCust_id(customer.getCust_id());
			c.setCust_name(customer.getCust_name());
			list.add(c);
		}
		
		JSONArray jsonArray = JSONArray.fromObject(list);
		// System.out.println(jsonArray.toString());
		// 将JSON数据传到页面
		try {
			ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
			ServletActionContext.getResponse().getWriter().println(jsonArray.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return NONE;
	}
}
