package com.jnshu.jdbc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jdbc")
public class JdbcController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/list")
    public List<Map<String,Object>> queryUsers(){
        List<Map<String,Object>> list=jdbcTemplate.queryForList("select * from users");
        return list;
    }

    @GetMapping("/user")
    public Map<String,Object> queryUserById(long id){
        Map<String,Object> map=jdbcTemplate.queryForMap("select * from users where id="+id);
        return map;
    }


}
