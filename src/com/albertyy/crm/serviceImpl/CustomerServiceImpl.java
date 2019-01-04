package com.albertyy.crm.serviceImpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.albertyy.crm.dao.CustomerDao;
import com.albertyy.crm.entity.Customer;
import com.albertyy.crm.service.CustomerService;
import com.albertyy.crm.utils.PageBean;
/*
 * 客户管理业务层实现类
 */
@Transactional
public class CustomerServiceImpl implements CustomerService {
    //注入Dao
	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
    //保存客户
	@Override
	public void save(Customer customer) {
		customerDao.save(customer);
	}
	//客户分页查询业务层方法
	@Override
	public PageBean<Customer> findByPage(DetachedCriteria detachedCriteria, Integer page, Integer pageSize) {
		PageBean<Customer> pageBean=new PageBean<Customer>();
		//封装当前页数
		pageBean.setPage(page);
		//封装每页记录数
		pageBean.setPageSize(pageSize);
		//封装总记录数,调用Dao查询
		Integer totalCount=customerDao.findCount(detachedCriteria);
		pageBean.setTotalCount(totalCount);
		//封装总页数
		Double tc=totalCount.doubleValue();
		Double num=Math.ceil(tc/pageSize);
		pageBean.setTotalPage(num.intValue());
		//封装每页显示数据的集合
		Integer begin=(page-1)*pageSize;
		List<Customer> list=customerDao.findByPage(detachedCriteria,begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	//根据id查询客户
	@Override
	public Customer findById(Long cust_id) {
		return customerDao.findById(cust_id) ;
	}
	//删除客户
	@Override
	public void delete(Customer customer) {
		customerDao.delete(customer);
		
	}
	
	//修改客户业务层方法
	@Override
	public void update(Customer customer) {
		customerDao.update(customer);
	}
	//查询所有客户
	@Override
	public List<Customer> findAll() {
		return customerDao.findAll();
	}
	
}
