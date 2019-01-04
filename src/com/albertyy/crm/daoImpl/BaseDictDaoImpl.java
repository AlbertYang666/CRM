/**  
 
* @Title: BaseDictDaoImpl.java
 
* @Package com.albertyy.crm.daoImpl
 
* @Description: TODO
 
* @author yangxianyang  
 
* @date 2018年12月16日 下午7:48:55
 
* @version V1.0  
 
*/

package com.albertyy.crm.daoImpl;

import java.util.List;

import com.albertyy.crm.dao.BaseDictDao;
import com.albertyy.crm.entity.BaseDict;

/**  
*   
* 项目名称：CRM  
* 类名称：BaseDictDaoImpl  
* 类描述：  字典的Dao实现类
* 创建人：yangyangyang  
* 创建时间：2018年12月16日 下午7:48:55  
* 修改人：yangyangyang  
* 修改时间：2018年12月16日 下午7:48:55  
* 修改备注：  
* @version   
*   
*/

public class BaseDictDaoImpl extends BaseDaoImpl<BaseDict> implements BaseDictDao {
    //根据类型编码查询字典数据
	@Override
	public List<BaseDict> findByTypeCode(String dict_type_code) {
		return (List<BaseDict>) this.getHibernateTemplate().find("from BaseDict where dict_type_code=?", dict_type_code);
	}

}
