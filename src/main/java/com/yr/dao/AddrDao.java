package com.yr.dao;

import com.yr.entity.Addr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

/**
 * @Auther: Administrator
 * @Date: 2018/12/12 20:07
 * @Description:
 */
public interface AddrDao extends CrudRepository<Addr,Integer> {


}
