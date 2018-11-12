package cn.itcast.oa.service;

import cn.itcast.oa.base.DaoSupport;
import cn.itcast.oa.domain.User;

public interface UserService extends DaoSupport<User> {

	/**
	 * 根据登录名和密码查询用户
	 * 
	 * @param loginName
	 * @param password
	 * @return
	 */
	User findByLoginNameAndPassword(String loginName, String password);

}
