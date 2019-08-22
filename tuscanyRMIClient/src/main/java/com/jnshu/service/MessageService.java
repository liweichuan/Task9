package com.jnshu.service;

import com.aliyuncs.exceptions.ClientException;
import org.mybatis.spring.annotation.MapperScan;


@MapperScan
public interface MessageService {
    boolean sendMesg(String phone, String message) throws ClientException;
}
