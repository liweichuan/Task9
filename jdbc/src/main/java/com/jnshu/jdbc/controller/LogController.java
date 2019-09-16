package com.jnshu.jdbc.controller;

import com.jnshu.jdbc.config.LogConfig;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController extends LogConfig {

    @RequestMapping("/log")
    public String showLog(){
        logger.debug("debug:Process in LogController.showLog method");//debug打不出来
        logger.info("info:Process in LogController.showLog method");
        logger.warn("warn:Process in LogController.showLog method");
        logger.error("error:Process in LogController.showLog method");
        return "SpringBoot Log";
    }
}
