package cn.tedu.store.service;

import cn.tedu.store.entity.User;

/**
 * 处理用户数据的业务层接口
 */
public interface IUserService {

	/**
	 * 用户注册
	 * @param user 用户信息
	 */
	void reg(User user);
	
	/**
	 * 用户登录
	 * @param username 用户名
	 * @param password 密码
	 * @return 成功登录的用户的数据
	 */
	User login(String username, String password);

	/**
	 * 修改密码
	 * @param uid 当前登录的用户的id
	 * @param username 当前登录的用户名
	 * @param oldPassword 原密码
	 * @param newPassword 新密码
	 * @return 
	 */
	void changePassword(Integer uid, String username, String oldPassword, String newPassword);
	
}






