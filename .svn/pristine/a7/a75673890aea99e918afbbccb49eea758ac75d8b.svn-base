/**  
 
* @Title: BaseDao.java
 
* @Package com.albertyy.crm.dao
 
* @Description: TODO
 
* @author yangxianyang  
 
* @date 2018年12月31日 下午5:10:09
 
* @version V1.0  
 
*/

package com.albertyy.crm.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

/**  
*   
* 项目名称：CRM  
* 类名称：BaseDao  
* 类描述： 通用Dao接口 
* 创建人：yangyangyang  
* 创建时间：2018年12月31日 下午5:10:09  
* 修改人：yangyangyang  
* 修改时间：2018年12月31日 下午5:10:09  
* 修改备注：  
* @version   
*   
*/

public interface BaseDao<T> {
   public void save(T t);
   public void update(T t);
   public void delete(T t);
   public T findById(Serializable id);
   //查询所有
   public List<T> findAll();
   //统计个数
   public Integer findCount(DetachedCriteria detachedCriteria);
   //分页查询
   public List<T> findByPage(DetachedCriteria detachedCriteria,Integer begin,Integer pageSize);
}
