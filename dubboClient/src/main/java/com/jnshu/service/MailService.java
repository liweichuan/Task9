package com.jnshu.service;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Mapper
@Component
public interface MailService {
    boolean sendMail(String email, String message) throws IOException;
}
