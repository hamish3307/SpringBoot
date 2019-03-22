package com.test.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>描述:
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2019/3/22 16:49
 * <p>作者: hha
 */
@Controller
@RequestMapping("/sys")
public class LoginController {

    @RequestMapping(value = "/toLogin")
    @GetMapping
    public ModelAndView doLogin(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }

}
