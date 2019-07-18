package com.test.springboot.controller;

import com.test.springboot.model.User;
import com.test.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Map<String, Object> findAll() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<User> userList = userService.findUserAll();
        modelMap.put("userList", userList);
        return modelMap;
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public Map<String, Object> findUserById(String id) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        User user = userService.findUserById(id);
        modelMap.put("user", user);
        return modelMap;
    }

    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    public Map<String, Object> saveOrUpdate(@RequestBody User user) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", userService.saveOrUpdate(user));
        return modelMap;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Map<String, Object> delete(String id) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", userService.delete(id));
        return modelMap;
    }

}
