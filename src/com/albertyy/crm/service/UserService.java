/**  
 
* @Title: UserService.java
 
* @Package com.albertyy.crm.service
 
* @Description: TODO
 
* @author yangxianyang  
 
* @date 2018年12月13日 上午11:40:33
 
* @version V1.0  
 
*/

package com.albertyy.crm.service;

import java.util.List;

import com.albertyy.crm.entity.User;

/**  
*   
* 项目名称：CRM  
* 类名称：UserService  
* 类描述：  
* 创建人：yangyangyang  
* 创建时间：2018年12月13日 上午11:40:33  
* 修改人：yangyangyang  
* 修改时间：2018年12月13日 上午11:40:33  
* 修改备注：  
* @version   
*   
*/

public interface UserService {

	void register(User user);

	User login(User user);

	List<User> findAll();

}
