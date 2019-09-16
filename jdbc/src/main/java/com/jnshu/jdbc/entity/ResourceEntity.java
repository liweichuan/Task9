package com.jnshu.jdbc.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ResourceEntity {

    @Value("${com.resource.resourceUrl}")
    private String resourceUrl;

    @Value("${com.resource.resourcePort}")
    private String resourcePort;

    @Value("${com.resource.maxNum}")
    private Integer maxNum;

    @Value("${com.resource.minNum}")
    private Integer minNum;

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public String getResourcePort() {
        return resourcePort;
    }

    public void setResourcePort(String resourcePort) {
        this.resourcePort = resourcePort;
    }

    public Integer getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(Integer maxNum) {
        this.maxNum = maxNum;
    }

    public Integer getMinNum() {
        return minNum;
    }

    public void setMinNum(Integer minNum) {
        this.minNum = minNum;
    }
}