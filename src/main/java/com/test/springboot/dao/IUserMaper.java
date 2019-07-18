package com.test.springboot.dao;

import com.test.springboot.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>描述:
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2019/1/23 17:32
 * <p>作者: hha
 */
@Mapper
public interface IUserMaper {

    @Select("select * from user")
    List<User> findUserAll();

    @Select("select * from user where id = #{id}")
    User findUserById(String id);

    @Insert("insert into user(id,name,age,sex,tel) values(#{id},#{name},#{age},#{sex},#{tel})")
    int save(User user);

    @Update("update user set name = #{name}, age = #{age}, sex = #{sex},tel = #{tel} where id = #{id}")
    int update(User user);

    @Delete("delete from user where id = #{id}")
    int delete(String id);

}
