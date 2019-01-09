package com.yr.service;

import java.util.*;

import com.yr.dao.AddrDao;
import com.yr.entity.Addr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yr.dao.UserDao;
import com.yr.entity.Page;
import com.yr.entity.User;
import com.yr.entity.UserPojo;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService{
	@Autowired
	//@Qualifier("userDaoImpl")
	private UserDao userDao;
	@Autowired
	private AddrDao addrDao;
	
	/**
	 * ��ҳ����ʽ��ѯuser�������
	 * @param page
	 */
	public void query(Page<UserPojo> page){
		page.setTotalCount(userDao.getCount(page));//��ѯ����������page��
		List<UserPojo> list = userDao.query(page);//��ҳ��ѯ������
		page.setDataList(list);
	}
	
	/**
	 * ����û���Ϣ
	 * @param user
	 */
	@Transactional
	public void add(User user){
		userDao.save(user);
		//userDao.add(user);
	}
	
	/**
	 * �޸��û���Ϣ
	 * @param user
	 */
	@Transactional
	public void update(User user){
		//userDao.update(user);
		userDao.save(user);
	}
	
	/**
	 * ɾ���û���Ϣ
	 * @param id
	 */
	@Transactional
	public void delete(Integer id){
		//userDao.delete(id);
		userDao.deleteById(id);
	}
	
	/**
	 * ����id��ѯ�û�����
	 * @param id
	 * @return User
	 */
	public User getById(Integer id){
		//return userDao.getById(id);
		//getOne()��ȡ����һ���յĶ���,��Ҫ�ô����
		Optional<User> option = userDao.findById(id);
		return option.get();
	}

	/**
	 * @describe: �������еĵ�ַ����һ��Ϊ��ַid���ڶ����ǵ�ַ����
	 * @return: java.util.Map<java.lang.Integer,java.lang.String>
	 * @auther: xiongdingkun
	 * @date: 2018/12/12 20:06
	 **/
	public Map<Integer,String> getAddrAll(){
		Iterable<Addr> iterable = addrDao.findAll();
		Iterator<Addr> iterator = iterable.iterator();
		Map<Integer,String> map = new HashMap<>();
		while(iterator.hasNext()){
			Addr addr = iterator.next();
			map.put(addr.getId(),addr.getName());
		}
		return map;
	}
}
