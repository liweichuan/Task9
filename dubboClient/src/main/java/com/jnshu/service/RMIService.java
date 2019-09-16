//package com.jnshu.service;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//import java.net.MalformedURLException;
//import java.rmi.Naming;
//import java.rmi.NotBoundException;
//import java.rmi.RemoteException;
//
//
///**
// * 随机选择RMI 服务端
// */
//@Component
//public class RMIService {
//
//    private static final Logger logger = LoggerFactory.getLogger(RMIService.class);
//
//
//    /**
//     * 随机数获取 StudentService (利用三目表达式） eg: A?B:C ,A为true,则为B,A为false,则为C
//     * 随机生成（0,1）内的数字，大于0.5 启动第1个service,小于0.5，则启动第2个service
//     * 如果发生异常，特别是与RMI相关的异常，则直接切换除自己以外的服务端
//     * @return studentService
//     */
//    public StudentService getStudentService()  {
//        StudentService studentService =  null ;
//        int randomNum = Math.random() >= 0.5 ? 1 : 0;
//        if (1 == randomNum) {
//            try {
//                //studentService = (StudentService) rmiProxyFactoryStudent1.getObject();
//                studentService = (StudentService) Naming.lookup("rmi://101.132.124.42:38388/studentRMI");
//            } catch (Exception e) {
//                logger.info("服务器1挂了，{}",e);
//                try {
//                    //studentService = (StudentService) rmiProxyFactoryStudent2.getObject();
//                    studentService = (StudentService) Naming.lookup("rmi://101.132.124.42:38488/studentRMI");
//                } catch (NotBoundException | MalformedURLException |RemoteException e1) {
//                    logger.info("服务器1,2都挂了，{}",e1);
//                }
//            }
//        }
//        else {
//            try {
//                //studentService = (StudentService) rmiProxyFactoryStudent1.getObject();
//                studentService = (StudentService) Naming.lookup("rmi://101.132.124.42:38488/studentRMI");
//            } catch (Exception e) {
//                logger.info("服务器2挂了，{}",e);
//                try {
//                    //studentService = (StudentService) rmiProxyFactoryStudent2.getObject();
//                    studentService = (StudentService) Naming.lookup("rmi://101.132.124.42:38388/studentRMI");
//                } catch (Exception e1) {
//                    logger.info("服务器1,2都挂了，{}",e1);
//                }
//            }
//        }
//        logger.info(" studentService:{}",studentService);
//        return studentService;
//    }
//
//
//    public UserService getUserService() {
//        UserService userService = null;
//        int randomNum = Math.random() >= 0.5 ? 1 : 0;
//        if (1 == randomNum) {
//            try {
//                userService = (UserService) Naming.lookup("rmi://101.132.124.42:38388/userRMI");
//            } catch (Exception e) {
//                logger.info("服务器1挂了，{}",e);
//                try {
//                    userService = (UserService) Naming.lookup("rmi://101.132.124.42:38488/userRMI");
//                } catch (Exception e1) {
//                    logger.info("服务器1,2都挂了，{}",e1);
//                }
//            }
//        }
//        else {
//            try {
//                userService = (UserService) Naming.lookup("rmi://101.132.124.42:38488/userRMI");
//            } catch (Exception e) {
//                logger.info("服务器2挂了，{}",e);
//                try {
//                    userService = (UserService) Naming.lookup("rmi://101.132.124.42:38388/userRMI");
//                } catch (Exception e1) {
//                    logger.info("服务器1,2都挂了，{}",e1);
//                }
//            }
//        }
//        logger.info("userService:{}",userService);
//        return userService;
//    }
//
//
//
//
//    public MailService getMailService() {
//        MailService mailService = null;
//        int randomNum = Math.random() >= 0.5 ? 1 : 0;
//        if (1 == randomNum) {
//            try {
//                mailService = (MailService) Naming.lookup("rmi://101.132.124.42:38388/mailRMI");
//            } catch (Exception e) {
//                logger.info("服务器1挂了，{}",e);
//                try {
//                    mailService = (MailService) Naming.lookup("rmi://101.132.124.42:38488/mailRMI");
//                } catch (Exception e1) {
//                    logger.info("服务器1,2都挂了，{}",e1);
//                }
//            }
//        }
//        else {
//            try {
//                mailService = (MailService) Naming.lookup("rmi://101.132.124.42:38488/mailRMI");
//            } catch (Exception e) {
//                logger.info("服务器2挂了，{}",e);
//                try {
//                    mailService = (MailService) Naming.lookup("rmi://101.132.124.42:38388/mailRMI");
//                } catch (Exception e1) {
//                    logger.info("服务器1,2都挂了，{}",e1);
//                }
//            }
//        }
//        logger.info("professionService:{}",mailService);
//        return mailService;
//    }
//
//
//    public UploadService getUplaodService() {
//
//        UploadService uploadService = null;
//        int randomNum = Math.random() >= 0.5 ? 1 : 0;
//        if (1 == randomNum) {
//            try {
//                uploadService = (UploadService) Naming.lookup("rmi://101.132.124.42:38388/uploadRMI");
//            } catch (Exception e) {
//                logger.info("服务器1挂了，{}",e);
//                try {
//                    uploadService = (UploadService) Naming.lookup("rmi://101.132.124.42:38488/uploadRMI");
//                } catch (Exception e1) {
//                    logger.info("服务器1,2都挂了，{}",e1);
//                }
//            }
//        }
//        else {
//            try {
//                uploadService = (UploadService) Naming.lookup("rmi://101.132.124.42:38488/uploadRMI");
//            } catch (Exception e) {
//                logger.info("服务器2挂了，{}",e);
//                try {
//                    uploadService = (UploadService) Naming.lookup("rmi://101.132.124.42:38388/uploadRMI");
//                } catch (Exception e1) {
//                    logger.info("服务器1,2都挂了，{}",e1);
//                }
//            }
//        }
//        logger.info("uploadService:{}",uploadService);
//        return uploadService;
//    }
//
//    public MessageService getMessageService() {
//
//        MessageService messageService = null;
//        int randomNum = Math.random() >= 0.5 ? 1 : 0;
//        if (1 == randomNum) {
//            try {
//                messageService = (MessageService) Naming.lookup("rmi://101.132.124.42:38388/messageRMI");
//            } catch (Exception e) {
//                logger.info("服务器1挂了，{}",e);
//                try {
//                    messageService = (MessageService) Naming.lookup("rmi://101.132.124.42:38488/messageRMI");
//                } catch (Exception e1) {
//                    logger.info("服务器1,2都挂了，{}",e1);
//                }
//            }
//        }
//        else {
//            try {
//                messageService = (MessageService) Naming.lookup("rmi://101.132.124.42:38488/messageRMI");
//            } catch (Exception e) {
//                logger.info("服务器2挂了，{}",e);
//                try {
//                    messageService = (MessageService) Naming.lookup("rmi://101.132.124.42:38388/messageRMI");
//                } catch (Exception e1) {
//                    logger.info("服务器1,2都挂了，{}",e1);
//                }
//            }
//        }
//        logger.info("uploadService:{}",messageService);
//        return messageService;
//    }
//
//    public RedisService getRedisService() {
//
//        RedisService redisService = null;
//        int randomNum = Math.random() >= 0.5 ? 1 : 0;
//        if (1 == randomNum) {
//            try {
//                redisService = (RedisService) Naming.lookup("rmi://101.132.124.42:38388/redisRMI");
//            } catch (Exception e) {
//                logger.info("服务器1挂了，{}",e);
//                try {
//                    redisService = (RedisService) Naming.lookup("rmi://101.132.124.42:38488/redisRMI");
//                } catch (Exception e1) {
//                    logger.info("服务器1,2都挂了，{}",e1);
//                }
//            }
//        }
//        else {
//            try {
//                redisService = (RedisService) Naming.lookup("rmi://101.132.124.42:38488/redisRMI");
//            } catch (Exception e) {
//                logger.info("服务器2挂了，{}",e);
//                try {
//                    redisService = (RedisService) Naming.lookup("rmi://101.132.124.42:38388/redisRMI");
//                } catch (Exception e1) {
//                    logger.info("服务器1,2都挂了，{}",e1);
//                }
//            }
//        }
//        logger.info("uploadService:{}",redisService);
//        return redisService;
//    }
//
//
//}