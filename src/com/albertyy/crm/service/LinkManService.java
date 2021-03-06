/**  
 
* @Title: LinkManService.java
 
* @Package com.albertyy.crm.service
 
* @Description: TODO
 
* @author yangxianyang  
 
* @date 2018年12月19日 下午5:32:30
 
* @version V1.0  
 
*/

package com.albertyy.crm.service;

import org.hibernate.criterion.DetachedCriteria;

import com.albertyy.crm.entity.LinkMan;
import com.albertyy.crm.utils.PageBean;

/**  
*   
* 项目名称：CRM  
* 类名称：LinkManService  
* 类描述：联系人业务层接口  
* 创建人：yangyangyang  
* 创建时间：2018年12月19日 下午5:32:30  
* 修改人：yangyangyang  
* 修改时间：2018年12月19日 下午5:32:30  
* 修改备注：  
* @version   
*   
*/

public interface LinkManService {

	PageBean<LinkMan> findByPage(DetachedCriteria detachedCriteria, Integer page, Integer pageSize);

	void save(LinkMan linkMan);

	LinkMan findById(Long lkm_id);

	void delete(LinkMan linkMan);

	void update(LinkMan linkMan);

}
