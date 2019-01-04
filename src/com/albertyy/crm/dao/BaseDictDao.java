/**  
 
* @Title: BaseDictDao.java
 
* @Package com.albertyy.crm.dao
 
* @Description: TODO
 
* @author yangxianyang  
 
* @date 2018年12月16日 下午7:47:39
 
* @version V1.0  
 
*/

package com.albertyy.crm.dao;

import java.util.List;

import com.albertyy.crm.entity.BaseDict;

/**  
*   
* 项目名称：CRM  
* 类名称：BaseDictDao  
* 类描述：字典的Dao接口  
* 创建人：yangyangyang  
* 创建时间：2018年12月16日 下午7:47:39  
* 修改人：yangyangyang  
* 修改时间：2018年12月16日 下午7:47:39  
* 修改备注：  
* @version   
*   
*/

public interface BaseDictDao extends BaseDao<BaseDict>{

	List<BaseDict> findByTypeCode(String dict_type_code);

}
