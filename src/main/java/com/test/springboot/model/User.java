package com.test.springboot.model;

import lombok.Data;

/**
 * <p>描述: 用户实体类
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2019/1/23 17:12
 * <p>作者: hha
 */
@Data
public class User {

    /* ID */
    private String id;
   /* 姓名 */
    private String name;
    /* 年龄 */
    private int age;
    /* 性别 */
    private String sex;
    /* 电话 */
    private String tel;

}
