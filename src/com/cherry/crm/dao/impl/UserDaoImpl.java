package com.cherry.crm.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.cherry.crm.dao.UserDao;
import com.cherry.crm.domain.User;
/**
 * 用户管理DAO的实现类
 * @author zhang
 *
 */
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	//DAO中根据用户名和密码进行查询的方法
	public User login(User user) {
//		List<User> list=(List<User>) this.getHibernateTemplate().find("from User where user_code=? and user_password=?", user.getUser_code(),user.getUser_password());
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(User.class);
		detachedCriteria.add(Restrictions.eq("user_code",user.getUser_code()));
		detachedCriteria.add(Restrictions.eq("user_password", user.getUser_password()));
		List<User> list = (List<User>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		//判断一下：
		if(list.size()>0) {
			return list.get(0);
		}
		return null;
	}
	
}
