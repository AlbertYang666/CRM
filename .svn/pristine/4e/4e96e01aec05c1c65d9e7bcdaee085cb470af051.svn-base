/**  
 
* @Title: LinkManServiceImpl.java
 
* @Package com.albertyy.crm.serviceImpl
 
* @Description: TODO
 
* @author yangxianyang  
 
* @date 2018年12月19日 下午5:33:38
 
* @version V1.0  
 
*/

package com.albertyy.crm.serviceImpl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.albertyy.crm.dao.LinkManDao;
import com.albertyy.crm.entity.LinkMan;
import com.albertyy.crm.service.LinkManService;
import com.albertyy.crm.utils.PageBean;

/**  
*   
* 项目名称：CRM  
* 类名称：LinkManServiceImpl  
* 类描述： 联系人业务层实现类 
* 创建人：yangyangyang  
* 创建时间：2018年12月19日 下午5:33:38  
* 修改人：yangyangyang  
* 修改时间：2018年12月19日 下午5:33:38  
* 修改备注：  
* @version   
*   
*/
@Transactional
public class LinkManServiceImpl implements LinkManService {
     //注入Dao
	private LinkManDao linkManDao;

	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}
    
	//业务层分页查询联系人
	@Override
	public PageBean<LinkMan> findByPage(DetachedCriteria detachedCriteria, Integer page, Integer pageSize) {
		PageBean<LinkMan> pageBean=new PageBean<LinkMan>();
		//设置当前页数
		pageBean.setPage(page);
		//设置每页显示记录数
		pageBean.setPageSize(pageSize);
		//设置总记录数
		int totalCount=linkManDao.findCount(detachedCriteria);
		pageBean.setTotalCount(totalCount);
		//设置总页数
		double tc=totalCount;
		Double num=Math.ceil(tc/pageSize);
		pageBean.setTotalPage(num.intValue());
		//每页显示数据的集合
		Integer begin=(page-1)*pageSize;
		List<LinkMan> list=linkManDao.findByPage(detachedCriteria,begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}
    //业务层保存联系人方法
	@Override
	public void save(LinkMan linkMan) {
		linkManDao.save(linkMan);
	}
    //根据id查询联系人
	@Override
	public LinkMan findById(Long lkm_id) {
		return linkManDao.findById(lkm_id);
	}
    //删除联系人
	@Override
	public void delete(LinkMan linkMan) {
		linkManDao.delete(linkMan);
	}
    //修改联系人
	@Override
	public void update(LinkMan linkMan) {
		linkManDao.update(linkMan);
    }
	
}
