package com.wangfugui.apprentice.service.impl;

import com.wangfugui.apprentice.common.util.ResultUtils;
import com.wangfugui.apprentice.dao.domain.User;
import com.wangfugui.apprentice.dao.mapper.UserMapper;
import com.wangfugui.apprentice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author MaSiyi
 * @version 1.0.0 2021/10/23
 * @since JDK 1.8.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResultUtils listUser() {
        List<User> users = userMapper.selectList(null);
        return ResultUtils.success(users);
    }

}
