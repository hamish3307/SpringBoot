package com.test.springboot.java8;

import com.test.springboot.config.TestConfig;
import com.test.springboot.model.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @描述: 面试测试
 * @Date: 2020/11/4 4:40 下午
 * @Author: hha
 */
public class Interview1Test {

    @Test
    public void toListTest() {
        // IOC 容器
        // 扫描User 注册到IOC容器中 实例化user
        // bean：IOC容器管理的对象，通过beanFactory：bean工厂
        ApplicationContext context = new AnnotationConfigApplicationContext(TestConfig.class);

        // NoSuchBeanDefinitionException
        System.out.println(context.getBean(User.class));

    }


}
