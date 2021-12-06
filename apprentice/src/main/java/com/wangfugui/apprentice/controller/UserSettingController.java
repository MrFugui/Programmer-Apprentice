package com.wangfugui.apprentice.controller;


import com.wangfugui.apprentice.common.util.ResponseUtils;
import com.wangfugui.apprentice.dao.dto.ApprenticeSettingDto;
import com.wangfugui.apprentice.dao.dto.NotifyUserSettingDto;
import com.wangfugui.apprentice.dao.dto.UserExtendDto;
import com.wangfugui.apprentice.service.IUserSettingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    private IUserSettingService userSettingService;

    @ApiOperation("更新个人信息")
    @PostMapping("/updateUserInfo")
    public ResponseUtils updateUserInfo(@RequestBody UserExtendDto userExtendDto) {
        return userSettingService.updateUserInfo(userExtendDto);
    }

    @ApiOperation("消息接收设置")
    @PostMapping("/notifyUserSetting")
    public ResponseUtils notifyUserSetting(@RequestBody NotifyUserSettingDto notifyUserSettingDto) {

        return userSettingService.notifyUserSetting(notifyUserSettingDto);
    }

    @ApiOperation("收徒拜师设置")
    @PostMapping("/apprenticeSetting")
    public ResponseUtils apprenticeSetting(@RequestBody ApprenticeSettingDto apprenticeSettingDto) {

        return userSettingService.apprenticeSetting(apprenticeSettingDto);
    }



}

