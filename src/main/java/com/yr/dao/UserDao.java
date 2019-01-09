package com.yr.dao;

import java.util.List;

import com.yr.entity.Page;
import com.yr.entity.User;
import com.yr.entity.UserPojo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface UserDao extends JpaRepository<User, Integer>,UserInterface{
}
