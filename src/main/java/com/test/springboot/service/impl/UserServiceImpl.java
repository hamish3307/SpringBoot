package com.test.springboot.service.impl;

import com.test.springboot.dao.IUserMaper;
import com.test.springboot.model.User;
import com.test.springboot.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>描述:
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2019/1/23 18:42
 * <p>作者: hha
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserMaper userMaper;

    @Override
    public List<User> findUserAll() {
        return userMaper.findUserAll();
    }

    @Override
    public List<User> findUserById(String id) {
        return userMaper.findUserById(id);
    }

    @Override
    public int save(User user) {
        return userMaper.save(user);
    }

    @Override
    public int update(User user) {
        return userMaper.update(user);
    }

    @Override
    public int delete(String id) {
        return userMaper.delete(id);
    }

}
