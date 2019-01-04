/**  
 
* @Title: SaleVisitService.java
 
* @Package com.albertyy.crm.service
 
* @Description: TODO
 
* @author yangxianyang  
 
* @date 2019年1月1日 下午5:14:54
 
* @version V1.0  
 
*/

package com.albertyy.crm.service;

import org.hibernate.criterion.DetachedCriteria;

import com.albertyy.crm.entity.SaleVisit;
import com.albertyy.crm.utils.PageBean;

/**  
*   
* 项目名称：CRM  
* 类名称：SaleVisitService  
* 类描述： 客户拜访Service接口 
* 创建人：yangyangyang  
* 创建时间：2019年1月1日 下午5:14:54  
* 修改人：yangyangyang  
* 修改时间：2019年1月1日 下午5:14:54  
* 修改备注：  
* @version   
*   
*/

public interface SaleVisitService {

	PageBean<SaleVisit> findByPage(DetachedCriteria detachedCriteria, Integer page, Integer pageSize);

	void save(SaleVisit saleVisit);

}
