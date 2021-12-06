package com.wangfugui.apprentice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangfugui.apprentice.common.util.ResponseUtils;
import com.wangfugui.apprentice.dao.domain.User;
import com.wangfugui.apprentice.dao.domain.UserExtend;
import com.wangfugui.apprentice.dao.domain.UserSetting;
import com.wangfugui.apprentice.dao.dto.NotifyUserSettingDto;
import com.wangfugui.apprentice.dao.dto.UserExtendDto;
import com.wangfugui.apprentice.dao.mapper.UserSettingMapper;
import com.wangfugui.apprentice.service.IUserExtendService;
import com.wangfugui.apprentice.service.IUserSettingService;
import com.wangfugui.apprentice.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * <p>
 * 用户设置表 服务实现类
 * </p>
 *
 * @author MrFugui
 * @since 2021-11-30
 */
@Service
public class UserSettingServiceImpl extends ServiceImpl<UserSettingMapper, UserSetting> implements IUserSettingService {

    @Autowired
    private IUserExtendService userExtendService;
    @Autowired
    private UserSettingMapper userSettingMapper;
    @Autowired
    private UserService userService;

    /**
     * 更新用户拓展信息
     *
     * @param userExtendDto
     * @Param: [userExtendDto]
     * @return: com.wangfugui.apprentice.common.util.ResponseUtils
     * @Author: MaSiyi
     * @Date: 2021/12/4
     */
    @Override
    public ResponseUtils updateUserInfo(UserExtendDto userExtendDto) {
        UserExtend userExtend = new UserExtend();
        BeanUtils.copyProperties(userExtendDto, userExtend);
        return ResponseUtils.success(userExtendService.saveOrUpdate(userExtend));
    }

    /**
     * 消息接收
     *
     * @param notifyUserSettingDto
     * @Param: [notifyUserSettingDto]
     * @return: com.wangfugui.apprentice.common.util.ResponseUtils
     * @Author: MaSiyi
     * @Date: 2021/12/4
     */
    @Override
    public ResponseUtils notifyUserSetting(NotifyUserSettingDto notifyUserSettingDto) {

        //获取当前用户信息
        User userInfo = userService.getUserInfo();
        Field[] declaredFields = notifyUserSettingDto.getClass().getDeclaredFields();
        ArrayList<UserSetting> userSettings = new ArrayList<>();
        UserSetting userSetting;
        for (int i = 0; i < declaredFields.length; i++) {
            userSetting = new UserSetting();
            userSetting.setUserId(userInfo.getId());
            Field declaredField = declaredFields[i];
            String settingKey = declaredField.getName();
            userSetting.setSettingKey(settingKey);
            try {
                declaredField.setAccessible(true);
                userSetting.setSettingValue(String.valueOf(declaredField.get(notifyUserSettingDto)));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            userSetting.setCreateTime(LocalDateTime.now());
            userSetting.setUpdateTime(LocalDateTime.now());
            userSetting.setSettingGroup("NotifyUserSetting");
            userSettings.add(userSetting);
        }
        this.saveBatch(userSettings);


        return ResponseUtils.success();
    }

}
