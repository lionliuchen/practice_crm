package com.cherry.crm.service;

import java.util.List;

import com.cherry.crm.domain.User;

/**
 * 用户管理Service的接口
 * @author zhang
 *
 */
public interface UserService {

	void regist(User user);

	User login(User user);

	List<User> findAll();

}
