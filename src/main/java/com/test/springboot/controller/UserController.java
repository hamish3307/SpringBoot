package com.test.springboot.controller;

import com.test.springboot.model.User;
import com.test.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>描述:
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2019/1/23 17:16
 * <p>作者: hha
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/all")
    public List<User> findAll(){
        return userService.findUserAll();
    }

    @RequestMapping("/find")
    public List<User> findUserById(String id){
        return userService.findUserById(id);
    }

    @RequestMapping("/save")
    public void saveOrUpdate(){

    }

    @RequestMapping("/delete")
    public void delete(){

    }

}
