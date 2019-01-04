/**  
 
* @Title: SaleVisitServiceImpl.java
 
* @Package com.albertyy.crm.serviceImpl
 
* @Description: TODO
 
* @author yangxianyang  
 
* @date 2019年1月1日 下午5:17:32
 
* @version V1.0  
 
*/

package com.albertyy.crm.serviceImpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.albertyy.crm.dao.SaleVisitDao;
import com.albertyy.crm.entity.SaleVisit;
import com.albertyy.crm.service.SaleVisitService;
import com.albertyy.crm.utils.PageBean;

/**  
*   
* 项目名称：CRM  
* 类名称：SaleVisitServiceImpl  
* 类描述：  客户拜访业务层实现类
* 创建人：yangyangyang  
* 创建时间：2019年1月1日 下午5:17:32  
* 修改人：yangyangyang  
* 修改时间：2019年1月1日 下午5:17:32  
* 修改备注：  
* @version   
*   
*/
@Transactional
public class SaleVisitServiceImpl implements SaleVisitService {
     //注入Dao
	private SaleVisitDao saleVisitDao;

	public void setSaleVisitDao(SaleVisitDao saleVisitDao) {
		this.saleVisitDao = saleVisitDao;
	}
    //客户拜访分页查询业务层方法
	@Override
	public PageBean<SaleVisit> findByPage(DetachedCriteria detachedCriteria, Integer page, Integer pageSize) {
		PageBean<SaleVisit> pageBean=new PageBean<SaleVisit>();
		pageBean.setPage(page);
		pageBean.setPageSize(pageSize);
		int totalCount=saleVisitDao.findCount(detachedCriteria);
		pageBean.setTotalCount(totalCount);
		double tc=totalCount;
		Double num=Math.ceil(tc/pageSize);
		pageBean.setTotalPage(num.intValue());
		Integer begin=(page-1)*pageSize;
		List<SaleVisit> list=saleVisitDao.findByPage(detachedCriteria, begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	//保存客户拜访记录
	@Override
	public void save(SaleVisit saleVisit) {
		saleVisitDao.save(saleVisit);
	}
	
}
