//import com.jnshu.service.*;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:applicationContext.xml")
//public class nullTest {
//    private Logger logger= LogManager.getLogger(nullTest.class);
//
//    @Autowired
//    MailService mailService;
//
//    @Autowired
//    MessageService messageService;
//
//    @Autowired
//    RedisService redisService;
//
//    @Autowired
//    UploadService uploadService;
//
//    @Autowired
//    StudentService studentService;
//
//    @Autowired
//    UserService userService;
//    @Test
//    public void serverTest()throws Exception{
//        logger.error("测试开始。。。。。。。。。。。。。。。");
//        if (mailService == null){
//            logger.error("mailServie为null");
//        }else {
//            logger.error("mailServie为"+mailService);
//        }
//        if (messageService == null){
//            logger.error("messageService为null");
//        }else {
//            logger.error("messageService为"+messageService);
//        }
//        if (redisService == null){
//            logger.error("redisService为null");
//        }else {
//            logger.error("redisService为"+redisService);
//        }
//        if (uploadService == null){
//            logger.error("uploadService为null");
//        }else{
//            logger.error("uploadService为"+uploadService);
//        }
//        if (studentService == null){
//            logger.error("studentService为null");
//        }else {
//            logger.error("studentService为"+studentService);
//        }
//        if (userService == null){
//            logger.error("userService为null");
//        }else {
//            logger.error("userService为"+userService);
//        }
//        logger.error("测试结束。。。。。。。。。。。。。");
//    }
//}
