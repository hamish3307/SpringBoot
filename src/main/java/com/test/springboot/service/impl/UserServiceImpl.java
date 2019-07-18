package com.test.springboot.service.impl;

import com.test.springboot.dao.IUserMaper;
import com.test.springboot.model.User;
import com.test.springboot.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
    public User findUserById(String id) {
        return userMaper.findUserById(id);
    }

    @Override
    public boolean saveOrUpdate(User user) {
        int num = 0;
        if (StringUtils.isEmpty(user.getId())) {
            num = userMaper.save(user);
        } else {
            num = userMaper.update(user);
        }
        if (num > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(String id) {
        int num = userMaper.delete(id);
        if (num > 0) {
            return true;
        } else {
            return false;
        }
    }

}
