/**  
 
* @Title: BaseDictServiceImpl.java
 
* @Package com.albertyy.crm.serviceImpl
 
* @Description: TODO
 
* @author yangxianyang  
 
* @date 2018年12月16日 下午7:51:38
 
* @version V1.0  
 
*/

package com.albertyy.crm.serviceImpl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.albertyy.crm.dao.BaseDictDao;
import com.albertyy.crm.entity.BaseDict;
import com.albertyy.crm.service.BaseDictService;

/**  
*   
* 项目名称：CRM  
* 类名称：BaseDictServiceImpl  
* 类描述：  字典业务层实现类
* 创建人：yangyangyang  
* 创建时间：2018年12月16日 下午7:51:38  
* 修改人：yangyangyang  
* 修改时间：2018年12月16日 下午7:51:38  
* 修改备注：  
* @version   
*   
*/
@Transactional
public class BaseDictServiceImpl implements BaseDictService {
   //注入Dao
	private BaseDictDao baseDictDao;

	public void setBaseDictDao(BaseDictDao baseDictDao) {
		this.baseDictDao = baseDictDao;
	}
    //业务层根据类型查询
	@Override
	public List<BaseDict> findByTypeCode(String dict_type_code) {
		return baseDictDao.findByTypeCode(dict_type_code);
	}
	
}
