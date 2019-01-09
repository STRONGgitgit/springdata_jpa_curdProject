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
	//��λ�ȡ���͵�ǰ��������� EntityManager ������ ?ͨ�� @PersistenceContext ע������ǳ�Ա����!
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * ��ѯ������
	 * @param page
	 * @return Integer
	 */
	public Integer getCount(Page<UserPojo> page){//@Paramָ�����Ǳ���
		String jpql = "select count(*) from User u where 1 = 1 ";
		if(!StringUtils.isEmpty(page.getT().getUser().getName())){//�ж��Ƿ�Ϊnull�Ϳ�
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
		return count.intValue();//��longתint
	}

	/**
	 * ��ҳ����ʽ��ѯuser�������
	 * @return List<User>
	 */
	public List<UserPojo> query(Page<UserPojo> page){
		String jpql = "select u from User u where 1 = 1 ";
		if(!StringUtils.isEmpty(page.getT().getUser().getName())){//�ж��Ƿ�Ϊnull�Ϳ�
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
			query.setParameter("endBirthday", DateUtils.toDate(page.getT().getEndBirthday()));//תsql date
		}
		if(!StringUtils.isEmpty(page.getT().getUser().getAddr().getName())){
			query.setParameter("addr", "%"+page.getT().getUser().getAddr().getName()+"%");
		}
		query.setFirstResult(page.getLimitNum()).setMaxResults(page.getPageSize());//��ѯ��ҳ
		List<UserPojo> list = query.getResultList();
		return list;
	}
}
