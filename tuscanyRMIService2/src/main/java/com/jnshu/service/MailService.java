package com.jnshu.service;


import org.oasisopen.sca.annotation.Remotable;

import java.io.IOException;

@Remotable
public interface MailService {
    boolean sendMail(String email, String message) throws IOException;
}
