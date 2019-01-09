package com.yr.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.util.StringUtils;

import com.yr.entity.Page;
import com.yr.entity.UserPojo;
import com.yr.util.DateUtils;

//@Repository("userDaoImpl")
public class UserDaoImpl implements UserInterface{
	//如何获取到和当前事务关联的 EntityManager 对象呢 ?通过 @PersistenceContext 注解来标记成员变量!
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * 查询总条数
	 * @param page
	 * @return Integer
	 */
	public Integer getCount(Page<UserPojo> page){//@Param指定的是别名
		String jpql = "select count(*) from User u where 1 = 1 ";
		if(!StringUtils.isEmpty(page.getT().getUser().getName())){//判断是否为null和空
			jpql += "and u.name like :name ";
		}
		if(!StringUtils.isEmpty(page.getT().getStartBirthday())){
			jpql += "and u.birthday >= :startBirthday ";
		}
		if(!StringUtils.isEmpty(page.getT().getEndBirthday())){
			jpql += "and u.birthday <= :endBirthday ";
		}
		if(!StringUtils.isEmpty(page.getT().getUser().getAddr().getName())){
			jpql += "and u.addr.name like :addr ";
		}
		Query query = entityManager.createQuery(jpql);
		if(!StringUtils.isEmpty(page.getT().getUser().getName())){
			query.setParameter("name", "%"+page.getT().getUser().getName()+"%");
		}
		if(!StringUtils.isEmpty(page.getT().getStartBirthday())){
			query.setParameter("startBirthday", DateUtils.toDate(page.getT().getStartBirthday()));
		}
		if(!StringUtils.isEmpty(page.getT().getEndBirthday())){
			query.setParameter("endBirthday", DateUtils.toDate(page.getT().getEndBirthday()));
		}
		if(!StringUtils.isEmpty(page.getT().getUser().getAddr().getName())){
			query.setParameter("addr", "%"+page.getT().getUser().getAddr().getName()+"%");
		}
		Long count = (Long)query.getSingleResult();
		return count.intValue();//将long转int
	}

	/**
	 * 分页的形式查询user表的数据
	 * @return List<User>
	 */
	public List<UserPojo> query(Page<UserPojo> page){
		String jpql = "select u from User u where 1 = 1 ";
		if(!StringUtils.isEmpty(page.getT().getUser().getName())){//判断是否为null和空
			jpql += "and u.name like :name ";
		}
		if(!StringUtils.isEmpty(page.getT().getStartBirthday())){
			jpql += "and u.birthday >= :startBirthday ";
		}
		if(!StringUtils.isEmpty(page.getT().getEndBirthday())){
			jpql += "and u.birthday <= :endBirthday ";
		}
		if(!StringUtils.isEmpty(page.getT().getUser().getAddr().getName())){
			jpql += "and u.addr.name like :addr ";
		}
		if(page.getT().getOrder() == 0){
			jpql += "order by u.id asc ";
		}else if(page.getT().getOrder() == 1){
			jpql += "order by u.id desc ";
		}
		Query query = entityManager.createQuery(jpql);
		if(!StringUtils.isEmpty(page.getT().getUser().getName())){
			query.setParameter("name", "%"+page.getT().getUser().getName()+"%");
		}
		if(!StringUtils.isEmpty(page.getT().getStartBirthday())){
			query.setParameter("startBirthday", DateUtils.toDate(page.getT().getStartBirthday()));
		}
		if(!StringUtils.isEmpty(page.getT().getEndBirthday())){
			query.setParameter("endBirthday", DateUtils.toDate(page.getT().getEndBirthday()));//转sql date
		}
		if(!StringUtils.isEmpty(page.getT().getUser().getAddr().getName())){
			query.setParameter("addr", "%"+page.getT().getUser().getAddr().getName()+"%");
		}
		query.setFirstResult(page.getLimitNum()).setMaxResults(page.getPageSize());//查询分页
		List<UserPojo> list = query.getResultList();
		return list;
	}
}
