/**  
 
* @Title: CustomerAction.java
 
* @Package com.albertyy.crm.web.action
 
* @Description: TODO
 
* @author yangxianyang  
 
* @date 2018年12月16日 下午4:07:41
 
* @version V1.0  
 
*/

package com.albertyy.crm.web.action;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.albertyy.crm.entity.Customer;
import com.albertyy.crm.service.CustomerService;
import com.albertyy.crm.utils.PageBean;
import com.albertyy.crm.utils.UploadUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import net.sf.json.JSONObject;

/**
 *        项目名称：CRM   类名称：CustomerAction   类描述：  客户管理Action 创建人：yangyangyang  
 * 创建时间：2018年12月16日 下午4:07:41   修改人：yangyangyang   修改时间：2018年12月16日 下午4:07:41  
 * 修改备注：   @version       
 */

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 模型驱动使用的对象
	private Customer customer = new Customer();

	@Override
	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}

	// 接收分页参数
	private Integer page = 1;

	public void setPage(Integer page) {
		if (page == null) {
			page = 1;
		}
		this.page = page;
	}

	private Integer pageSize = 5;

	public void setPageSize(Integer pageSize) {
		if (pageSize == null) {
			pageSize = 5;
		}
		this.pageSize = pageSize;
	}

	// 注入Services
	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	/*
	 * 文件上传提供的三个属性
	 */
	private String fileFileName;// 文件名称
	private File file;// 上传的文件
	@SuppressWarnings("unused")
	private String fileContentType;// 文件类型

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	// 客户管理跳转到添加页面
	public String saveUI() {
		return "saveUI";
	}

	// 保存客户的方法
	public String save() {
		// 上传文件
		if (file != null) {
			// 设置上传路径
			String directory = "/upload";
			String path = ServletActionContext.getServletContext().getRealPath(directory);

			// System.out.println(file);
			// 为了防止一个目录下存放相同的文件名：使用随机文件名
			String uuidFileName = UploadUtils.getUuidFileName(fileFileName);
			// 为了防止一个目录下存放的文件过多：目录分离
			String realPath = UploadUtils.getPath(uuidFileName);
			// 创建目录
			String url = path + realPath;
			File ml = new File(url);
			if (!ml.exists()) {
				ml.mkdirs();
			}
			// 文件上传
			File dictFile = new File(url + "/" + uuidFileName);
			try {
				FileUtils.copyFile(file, dictFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 设置image的值
			customer.setCust_image(url + "/" + uuidFileName);
		}

		// 保存客户
		customerService.save(customer);
		// 跳转到查询页面
		// 接收分页参数
		// 最好使用DetachedCriteria对象(带分页的条件查询)
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
		// 设置条件
		if (customer.getCust_name() != null && !customer.getCust_name().trim().equals("")) {
			detachedCriteria.add(Restrictions.like("cust_name", customer.getCust_name() + "%"));
		}
		if (customer.getBaseDictSource() != null) {
			if (customer.getBaseDictSource().getDict_id() != null
					&& !customer.getBaseDictSource().getDict_id().trim().equals("")) {
				detachedCriteria
						.add(Restrictions.like("baseDictSource.dict_id", customer.getBaseDictSource().getDict_id()));
			}

		}
		if (customer.getBaseDictIndustry() != null) {
			if (customer.getBaseDictIndustry().getDict_id() != null
					&& !customer.getBaseDictIndustry().getDict_id().trim().equals("")) {
				detachedCriteria.add(
						Restrictions.like("baseDictIndustry.dict_id", customer.getBaseDictIndustry().getDict_id()));
			}

		}
		if (customer.getBaseDictLevel() != null) {
			if (customer.getBaseDictLevel().getDict_id() != null
					&& !customer.getBaseDictLevel().getDict_id().trim().equals("")) {
				detachedCriteria
						.add(Restrictions.like("baseDictLevel.dict_id", customer.getBaseDictLevel().getDict_id()));
			}

		}

		// 调用业务层查询
		PageBean<Customer> pageBean = customerService.findByPage(detachedCriteria, page, pageSize);
		ActionContext.getContext().getValueStack().push(pageBean);

		return "findAll";
	}

	// 查询客户列表方法
	public String findAll() {
		// 接收分页参数
		// 最好使用DetachedCriteria对象(带分页的条件查询)
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
		// 设置条件
		if (customer.getCust_name() != null && !customer.getCust_name().trim().equals("")) {
			detachedCriteria.add(Restrictions.like("cust_name", customer.getCust_name() + "%"));
		}
		if (customer.getBaseDictSource() != null) {
			if (customer.getBaseDictSource().getDict_id() != null
					&& !customer.getBaseDictSource().getDict_id().trim().equals("")) {
				detachedCriteria
						.add(Restrictions.like("baseDictSource.dict_id", customer.getBaseDictSource().getDict_id()));
			}

		}
		if (customer.getBaseDictIndustry() != null) {
			if (customer.getBaseDictIndustry().getDict_id() != null
					&& !customer.getBaseDictIndustry().getDict_id().trim().equals("")) {
				detachedCriteria.add(
						Restrictions.like("baseDictIndustry.dict_id", customer.getBaseDictIndustry().getDict_id()));
			}

		}
		if (customer.getBaseDictLevel() != null) {
			if (customer.getBaseDictLevel().getDict_id() != null
					&& !customer.getBaseDictLevel().getDict_id().trim().equals("")) {
				detachedCriteria
						.add(Restrictions.like("baseDictLevel.dict_id", customer.getBaseDictLevel().getDict_id()));
			}

		}

		// 调用业务层查询
		PageBean<Customer> pageBean = customerService.findByPage(detachedCriteria, page, pageSize);
		ActionContext.getContext().getValueStack().push(pageBean);

		return "findAll";
	}

	// 删除客户的方法
	public String delete() {
		customer = customerService.findById(customer.getCust_id());
		// 删除图片
		String cust_image = customer.getCust_image();
		if (cust_image != null && !cust_image.trim().equals("")) {
			File existfile = new File(cust_image);
			if (existfile.exists()) {
				existfile.delete();
			}
		}
		// 删除客户
		customerService.delete(customer);
		return "deleteSuccess";
	}

	// 用户修改异步查询信息的方法
	public String edit() {
		customer = customerService.findById(customer.getCust_id());
		// 把需要传送的数据封装成map集合
		Map map = new TreeMap();
		map.put("cust_id", customer.getCust_id());
		map.put("cust_name", customer.getCust_name());
		map.put("cust_source", customer.getBaseDictSource().getDict_id());
		map.put("cust_industry", customer.getBaseDictIndustry().getDict_id());
		map.put("cust_level", customer.getBaseDictLevel().getDict_id());
		map.put("cust_phone", customer.getCust_phone());
		map.put("cust_mobile", customer.getCust_mobile());
		map.put("cust_image", customer.getCust_image());

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

	// 客户修改的方法
	public String update() {
		// 修改图片，获得原来的图片同时，上传新图片
		if (file != null) {
			String cust_image = customer.getCust_image();
			if (cust_image != null && !cust_image.trim().equals("")) {
				File exitfile = new File(cust_image);
				if (exitfile.exists()) {
					exitfile.delete();
				}
			}

			// 上传图片
			// 设置上传路径
			String directory = "/upload";
			String path = ServletActionContext.getServletContext().getRealPath(directory);

			// System.out.println(file);
			// 为了防止一个目录下存放相同的文件名：使用随机文件名
			String uuidFileName = UploadUtils.getUuidFileName(fileFileName);
			// 为了防止一个目录下存放的文件过多：目录分离
			String realPath = UploadUtils.getPath(uuidFileName);
			// 创建目录
			String url = path + realPath;
			File ml = new File(url);
			if (!ml.exists()) {
				ml.mkdirs();
			}
			// 文件上传
			File dictFile = new File(url + "/" + uuidFileName);
			try {
				FileUtils.copyFile(file, dictFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 重新设置image的值
			customer.setCust_image(url + "/" + uuidFileName);
		}

		customerService.update(customer);
		return "updateSuccess";
	}
}
