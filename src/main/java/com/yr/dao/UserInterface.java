package com.yr.dao;

import com.yr.entity.Page;
import com.yr.entity.UserPojo;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/12/12 19:36
 * @Description:
 */
public interface UserInterface {

    Integer getCount(Page<UserPojo> page);

    List<UserPojo> query(Page<UserPojo> page);
}
