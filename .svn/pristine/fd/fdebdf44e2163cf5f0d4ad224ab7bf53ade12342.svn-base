/**  
 
* @Title: BaseDaoImpl.java
 
* @Package com.albertyy.crm.daoImpl
 
* @Description: TODO
 
* @author yangxianyang  
 
* @date 2018年12月31日 下午5:12:42
 
* @version V1.0  
 
*/

package com.albertyy.crm.daoImpl;

import java.util.List;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.albertyy.crm.dao.BaseDao;


/**
 *        项目名称：CRM   类名称：BaseDaoImpl   类描述： 通用Dao实现类  创建人：yangyangyang  
 * 创建时间：2018年12月31日 下午5:12:42   修改人：yangyangyang   修改时间：2018年12月31日 下午5:12:42  
 * 修改备注：   @version       
 */

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	private Class clazz;

	/*
	 * 提供无参的构造方法，获得具体类型Class 具体类型的Class是参数类型中的实际类型参数
	 */
	public BaseDaoImpl() {
		// 反射：第一步获得Class
		Class clazz = this.getClass();
		// 得到参数化类型：例如BaseDaoImpl<Customer>,BaseDaoImpl<LinkMan>
		Type type = clazz.getGenericSuperclass();
		// 得到的type就是一个参数化的类型，将type强转成参数化类型
		ParameterizedType ptype = (ParameterizedType) type;
		// 通过参数化类型获得实际类型参数：得到的是一个数组
		Type[] types = ptype.getActualTypeArguments();
		// 获得第一个实际类型参数
		this.clazz = (Class) types[0];
	}

	@Override
	public void save(T t) {
		this.getHibernateTemplate().save(t);
	}

	@Override
	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	@Override
	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
	}
    //通过ID查询
	@Override
	public T findById(Serializable id) {
		return (T) this.getHibernateTemplate().get(clazz, id);
	}
	
	// 查询所有
	@Override
	public List<T> findAll() {
		return (List<T>) this.getHibernateTemplate().find("from " + clazz.getSimpleName());
	}

	// 统计个数
	@Override
	public Integer findCount(DetachedCriteria detachedCriteria) {
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> count = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		if (count.size() > 0) {
			return count.get(0).intValue();
		}
		return null;
	}

	// 分页查询
	@Override
	public List<T> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize) {
		detachedCriteria.setProjection(null);
        return (List<T>) this.getHibernateTemplate().findByCriteria(detachedCriteria, begin, pageSize);
	}

	

}
