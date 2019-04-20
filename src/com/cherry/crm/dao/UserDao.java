package com.cherry.crm.dao;

import com.cherry.crm.domain.User;

/**
 * 用户管理的DAO的接口
 * @author zhang
 *
 */
public interface UserDao extends BaseDao<User>{

	User login(User user);

}
