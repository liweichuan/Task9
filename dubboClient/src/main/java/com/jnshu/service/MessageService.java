package com.jnshu.service;

import com.aliyuncs.exceptions.ClientException;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


@Mapper
@Component
public interface MessageService {
    boolean sendMesg(String phone, String message) throws ClientException;
}
