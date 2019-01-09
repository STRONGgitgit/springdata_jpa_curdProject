package com.yr.service;

import com.yr.entity.Page;
import com.yr.entity.User;
import com.yr.entity.UserPojo;

import java.util.Map;

public interface UserService {

	/**
	 * 分页的形式查询user表的数据
	 * @param page
	 */
	void query(Page<UserPojo> page);
	
	/**
	 * 添加用户信息
	 * @param user
	 */
	void add(User user);
	
	/**
	 * 修改用户信息
	 * @param user
	 */
	void update(User user);
	
	/**
	 * 删除用户信息
	 * @param id
	 */
	void delete(Integer id);
	
	/**
	 * 根据id查询用户数据
	 * @param id
	 * @return User
	 */
	User getById(Integer id);

	/**
	 * @describe: 返回所有的地址，第一个为地址id，第二个是地址名字
	 * @return: java.util.Map<java.lang.Integer,java.lang.String>
	 * @auther: xiongdingkun
	 * @date: 2018/12/12 20:06
	 **/
	Map<Integer,String> getAddrAll();
}
