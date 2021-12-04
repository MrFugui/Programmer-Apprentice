package com.wangfugui.apprentice.controller;


import com.wangfugui.apprentice.service.IUserSettingService;
import com.wangfugui.apprentice.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户设置表 前端控制器
 * </p>
 *
 * @author MrFugui
 * @since 2021-11-30
 */
@RestController
@RequestMapping("/apprentice/userSetting")
@Api(tags = "用户设置")
public class UserSettingController {

    @Autowired
    private UserService userService;
    @Autowired
    private IUserSettingService userSettingService;

//    @ApiOperation("更新个人信息")
//    public ResponseUtils updateUserInfo() {
//
//    }

}

