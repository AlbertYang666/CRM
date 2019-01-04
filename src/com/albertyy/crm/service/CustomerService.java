/**  
 
* @Title: CustomerService.java
 
* @Package com.albertyy.crm.service
 
* @Description: TODO
 
* @author yangxianyang  
 
* @date 2018年12月16日 下午4:11:14
 
* @version V1.0  
 
*/

package com.albertyy.crm.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.albertyy.crm.entity.Customer;
import com.albertyy.crm.utils.PageBean;

/**  
*   
* 项目名称：CRM  
* 类名称：CustomerService  
* 类描述：客户管理业务层接口  
* 创建人：yangyangyang  
* 创建时间：2018年12月16日 下午4:11:14  
* 修改人：yangyangyang  
* 修改时间：2018年12月16日 下午4:11:14  
* 修改备注：  
* @version   
*   
*/

public interface CustomerService {

	void save(Customer customer);

	PageBean<Customer> findByPage(DetachedCriteria detachedCriteria, Integer page, Integer pageSize);

	Customer findById(Long cust_id);

	void delete(Customer customer);

	void update(Customer customer);

	List<Customer> findAll();

}
