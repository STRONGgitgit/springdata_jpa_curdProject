package com.yr.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Cacheable(true)
@Entity
public class User implements Serializable{//实体类序列化
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private Integer sex;
	//定义时间格式	自动更新时间
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date birthday;
	private String email;
	private Integer state;
	private String password;
	//级联保存、更新、删除、刷新;延迟加载。当删除用户，会级联删除该用户的所有文章
	//拥有mappedBy注解的实体类为关系被维护端
	//mappedBy="author"中的author是Article中的author属性
	@ManyToOne(/*cascade=CascadeType.MERGE,*/fetch=FetchType.EAGER)
	@JoinColumn(name="addr_id")//在book表增加一个外键列来实现一对多的单向关联
	private Addr addr;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Addr getAddr() {
		return addr;
	}

	public void setAddr(Addr addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", sex=" + sex +
				", addr=" + addr +
				", birthday=" + birthday +
				", email='" + email + '\'' +
				", state=" + state +
				", password='" + password + '\'' +
				'}';
	}
}
