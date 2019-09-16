package com.jnshu.jdbc;

import com.jnshu.jdbc.config.LogConfig;
import com.jnshu.jdbc.domain.User;
import com.jnshu.jdbc.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcApplicationTests  {
    Logger logger= LoggerFactory.getLogger(JdbcApplicationTests.class);
    @Autowired
    private UserRepository userRepository;

    @Test public void testAll(){
        findAllUsers();
        findUserById();
        createUser();
    }

    @Test
    public void findAllUsers()  {
        List<User> users = userRepository.findAll();
        assertNotNull(users);
        assertTrue(!users.isEmpty());
    }

    @Test
    public void findUserById()  {
        User user = userRepository.findUserById(10);
        assertNotNull(user);
    }

    private void updateById(Integer id)  {
        User newUser = new User(id, "JackChen", "123456","13554564964");
        userRepository.update(newUser);
        User newUser2 = userRepository.findUserById(newUser.getId());
        assertEquals(newUser.getUsername(), newUser2.getUsername());
        assertEquals(newUser.getPassword(), newUser2.getPassword());
        assertEquals(newUser.getPhone(), newUser2.getPhone());
    }
    @Test
    public void createUser() {
        User user = new User(0, "tom","123456", "13584568524");
        User savedUser = userRepository.create(user);
        logger.debug("{}",savedUser);
        logger.debug(String.valueOf(savedUser));
//        User newUser = userRepository.findUserById(savedUser.getId());
//        assertEquals("tom", newUser.getUsername());
//        assertEquals("123456", newUser.getPassword());
//        assertEquals("13584568524", newUser.getPhone());
//        updateById(newUser.getId());
//        userRepository.delete(newUser.getId());
    }
}
