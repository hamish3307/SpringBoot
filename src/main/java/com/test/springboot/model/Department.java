package com.test.springboot.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @描述: 部门
 * @Date: 2020-05-14 14:03
 * @Author: hha
 */
@Data
public class Department implements Serializable {

    private static final long serialVersionUID = 3467820988743231804L;
    /**
     * 部门ID
     */
    private String id;
    /**
     * 部门名称
     */
    private String name;
    /**
     * 管理者
     */
    private String manager;
    /**
     * 部门电话
     */
    private String tel;
    /**
     * 成立时间
     */
    private Date createTime;
    /**
     * 成员数量
     */
    private Long memberNum;
    /**
     * 部门用户集合
     */
    private List<User> userList;

}
