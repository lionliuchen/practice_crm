package com.cherry.crm.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.cherry.crm.dao.UserDao;
import com.cherry.crm.domain.User;
import com.cherry.crm.service.UserService;
import com.cherry.crm.utils.MD5Utils;
/**
 * 用户管理Service的实现类
 * @author zhang
 *
 */
@Transactional
public class UserServiceImpl implements UserService {

	//注入DAO
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	@Override
	//业务层注册用户的方法
	public void regist(User user) {
		//对密码进行加密处理：
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		user.setUser_state("1");
		//调用DAO
		userDao.save(user);
	}


	@Override
	//业务层用户登陆的方法
	public User login(User user) {
		user.setUser_password(MD5Utils.md5(user.getUser_password()));
		//调用DAO
		return userDao.login(user);
	}


	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

}
