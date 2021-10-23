package com.wangfugui.apprentice.controller;

import com.wangfugui.apprentice.common.util.ResultUtils;
import com.wangfugui.apprentice.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MaSiyi
 * @version 1.0.0 2021/10/23
 * @since JDK 1.8.0
 */
@RestController
@Api(tags = "用户管理")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("查询所有用户")
    @GetMapping("listUser")
    public ResultUtils listUser() {
        return userService.listUser();
    }
}
