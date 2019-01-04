/**  
 
* @Title: UserDaoImpl.java
 
* @Package com.albertyy.crm.daoImpl
 
* @Description: TODO
 
* @author yangxianyang  
 
* @date 2018年12月13日 上午11:40:00
 
* @version V1.0  
 
*/

package com.albertyy.crm.daoImpl;

import java.util.List;


import com.albertyy.crm.dao.UserDao;
import com.albertyy.crm.entity.User;

/**  
*   
* 项目名称：CRM  
* 类名称：UserDaoImpl  
* 类描述：UserDao实现类  
* 创建人：yangyangyang  
* 创建时间：2018年12月13日 上午11:40:00  
* 修改人：yangyangyang  
* 修改时间：2018年12月13日 上午11:40:00  
* 修改备注：  
* @version   
*   
*/

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
   
    //查找方法:根据用户名和密码进行查询
	@Override
	public User find(User user) {
		List<User> users=(List<User>) this.getHibernateTemplate().find("from User where user_code=? and user_password=?", user.getUser_code(),user.getUser_password());
		if(users.size()>0){
			return users.get(0);
		}
		return null;
	}

}