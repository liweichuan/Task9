package com.jnshu.jdbc.controller;

import com.jnshu.jdbc.entity.ResourceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

    @Autowired
    private ResourceEntity resourceEntity;

    @RequestMapping("/resource")
    public ResourceEntity getResource() {
        return resourceEntity;
    }
}