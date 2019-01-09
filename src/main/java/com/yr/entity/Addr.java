package com.yr.entity;

import javax.persistence.*;

/**
 * @Auther: Administrator
 * @Date: 2018/12/12 20:09
 * @Description:
 */
@Cacheable(true)
@Entity
public class Addr {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;

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

    @Override
    public String toString() {
        return "Addr{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
