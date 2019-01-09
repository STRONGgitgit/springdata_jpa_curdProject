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
	 * 分页的形式查询user表的数据
	 * @param page
	 */
	public void query(Page<UserPojo> page){
		page.setTotalCount(userDao.getCount(page));//查询总条数加入page中
		List<UserPojo> list = userDao.query(page);//分页查询的数据
		page.setDataList(list);
	}
	
	/**
	 * 添加用户信息
	 * @param user
	 */
	@Transactional
	public void add(User user){
		userDao.save(user);
		//userDao.add(user);
	}
	
	/**
	 * 修改用户信息
	 * @param user
	 */
	@Transactional
	public void update(User user){
		//userDao.update(user);
		userDao.save(user);
	}
	
	/**
	 * 删除用户信息
	 * @param id
	 */
	@Transactional
	public void delete(Integer id){
		//userDao.delete(id);
		userDao.deleteById(id);
	}
	
	/**
	 * 根据id查询用户数据
	 * @param id
	 * @return User
	 */
	public User getById(Integer id){
		//return userDao.getById(id);
		//getOne()获取的是一个空的对象,不要用错对象
		Optional<User> option = userDao.findById(id);
		return option.get();
	}

	/**
	 * @describe: 返回所有的地址，第一个为地址id，第二个是地址名字
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
