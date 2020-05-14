package com.test.springboot.tools.json;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.test.springboot.model.Department;
import com.test.springboot.model.User;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @描述:
 * @Date: 2020-05-14 14:00
 * @Author: hha
 */
public class FastjsonTest {

    @Test
    public void jsonTest() throws ParseException {

        String departmentStr = JSONObject.toJSONStringWithDateFormat(this.createDepartment(), "yyyyMMdd");
        System.out.println(departmentStr);

        Department department = JSONObject.parseObject(departmentStr, Department.class);
        System.out.println(department);

    }

    private Department createDepartment() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Department department = new Department();
        List<User> userList = Lists.newArrayList();
        User user1 = new User();
        user1.setId("1");
        user1.setName("Hamish");
        user1.setAge(28);
        user1.setSex("男");
        user1.setTel("0794-7710013");
        user1.setBirthday(sdf.parse("1992-06-03"));
        userList.add(user1);

        User user2 = new User();
        user2.setId("2");
        user2.setName("Amy");
        user2.setAge(28);
        user2.setSex("女");
        user2.setTel("0794-7710014");
        user2.setBirthday(sdf.parse("1992-09-22"));
        userList.add(user2);

        department.setId("d1");
        department.setName("测试部门1");
        department.setManager("Servyou");
        department.setCreateTime(new Date());
        department.setMemberNum(new Long(10));
        department.setTel("123456789");
        department.setUserList(userList);
        return department;
    }

}
