package com.example.demo.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.util.Constant;

/**
 * @author lijinfei
 * @date 2020/3/26 14:45 Version: 1.0
 */
@RestControllerAdvice
public class ExceptionHandler {

    private static final Logger logger = LogManager.getLogger(ExceptionHandler.class);
    private static final String ERROR_MESSAGE = "后台跑丢了，sorry";

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public Object handlerException(Exception e) {
        // 返回给前台
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.STATUS, 500);
        jsonObject.put(Constant.MESSAGE, ERROR_MESSAGE);
        // 日志记录错误，包括堆栈信息
        logger.error(e.getMessage(), e);
        return jsonObject;
    }
}
