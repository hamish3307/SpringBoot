package com.test.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>描述: 测试SpringBoot
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2018/10/15 15:53
 * <p>作者: hha
 */
@RestController
//该注解是 @Controller 和 @ResponseBody 注解的合体版
public class HelloController {

    /**
     * <p>描述: 测试Hello方法
     * <p>日期: 2018/10/15 15:56
     * <p>作者: hha
     * @param
     * @return
     */
    @RequestMapping("/hello")
    public String sayHello(){
        return "Hello Spring Boot!!!";
    }

}
