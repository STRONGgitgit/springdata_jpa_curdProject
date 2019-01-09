package com.yr.service;

import com.yr.entity.Page;
import com.yr.entity.User;
import com.yr.entity.UserPojo;

import java.util.Map;

public interface UserService {

	/**
	 * ��ҳ����ʽ��ѯuser�������
	 * @param page
	 */
	void query(Page<UserPojo> page);
	
	/**
	 * ����û���Ϣ
	 * @param user
	 */
	void add(User user);
	
	/**
	 * �޸��û���Ϣ
	 * @param user
	 */
	void update(User user);
	
	/**
	 * ɾ���û���Ϣ
	 * @param id
	 */
	void delete(Integer id);
	
	/**
	 * ����id��ѯ�û�����
	 * @param id
	 * @return User
	 */
	User getById(Integer id);

	/**
	 * @describe: �������еĵ�ַ����һ��Ϊ��ַid���ڶ����ǵ�ַ����
	 * @return: java.util.Map<java.lang.Integer,java.lang.String>
	 * @auther: xiongdingkun
	 * @date: 2018/12/12 20:06
	 **/
	Map<Integer,String> getAddrAll();
}
