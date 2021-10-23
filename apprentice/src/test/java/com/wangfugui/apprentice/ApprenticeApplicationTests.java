package com.wangfugui.apprentice;

import com.wangfugui.apprentice.dao.domain.User;
import com.wangfugui.apprentice.dao.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ApprenticeApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        users.stream().forEach(System.out::println);
    }

}
