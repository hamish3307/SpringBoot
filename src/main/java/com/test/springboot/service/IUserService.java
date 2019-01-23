package com.test.springboot.service;

import com.test.springboot.model.User;

import java.util.List;

/**
 * <p>描述:
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2019/1/23 17:36
 * <p>作者: hha
 */
public interface IUserService {

    List<User> findUserAll();

    List<User> findUserById(String id);

    int save(User user);

    int update(User user);

    int delete(String id);

}
