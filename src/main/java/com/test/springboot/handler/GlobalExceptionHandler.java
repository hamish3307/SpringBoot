package com.test.springboot.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>描述: 全局异常处理类
 * <p>版权: 税友软件集团股份有限公司
 * <p>日期: 2019/7/18 11:33
 * <p>作者: hha
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Map<String, Object> exceptionHandler(HttpServletRequest req, Exception e) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",false);
        modelMap.put("errMsg",e.getMessage());
        return modelMap;
    }

}
