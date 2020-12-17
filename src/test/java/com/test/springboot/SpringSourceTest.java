package com.test.springboot;

import com.test.springboot.config.SwaggerConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @描述:
 * @Date: 2020/12/7 下午2:31
 * @Author: hha
 */
public class SpringSourceTest {

    @Test
    public void springTest() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SwaggerConfig.class);
        Docket docket = (Docket) context.getBean("docket");
        System.out.println("Docket=" + docket);
    }

}
