package com.jnshu.service;

import com.aliyuncs.exceptions.ClientException;
import org.oasisopen.sca.annotation.Remotable;

@Remotable
public interface MessageService {
    boolean sendMesg(String phone, String message) throws ClientException;
}
