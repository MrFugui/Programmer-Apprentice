package com.wangfugui.apprentice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangfugui.apprentice.common.constant.UserSettingConstant;
import com.wangfugui.apprentice.common.util.ResponseUtils;
import com.wangfugui.apprentice.dao.domain.User;
import com.wangfugui.apprentice.dao.domain.UserExtend;
import com.wangfugui.apprentice.dao.domain.UserSetting;
import com.wangfugui.apprentice.dao.dto.ApprenticeSettingDto;
import com.wangfugui.apprentice.dao.dto.ApprenticeSettingExtendDto;
import com.wangfugui.apprentice.dao.dto.NotifyUserSettingDto;
import com.wangfugui.apprentice.dao.dto.UserDto;
import com.wangfugui.apprentice.dao.dto.UserExtendDto;
import com.wangfugui.apprentice.dao.mapper.UserSettingMapper;
import com.wangfugui.apprentice.service.IUserExtendService;
import com.wangfugui.apprentice.service.IUserSettingService;
import com.wangfugui.apprentice.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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
     * 更新用户信息
     *
     * @param
     * @Param: [userExtendDto]
     * @return: com.wangfugui.apprentice.common.util.ResponseUtils
     * @Author: MaSiyi
     * @Date: 2021/12/4
     */
    @Override
    public ResponseUtils updateUserInfo(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        //本身信息
        userService.saveOrUpdate(user);
        //拓展信息
        UserExtend userExtend = new UserExtend();
        UserExtendDto userExtendDto = userDto.getUserExtendDto();
        if (!ObjectUtils.isEmpty(userExtendDto)) {

            Integer extendId = userExtendDto.getExtendId();
            BeanUtils.copyProperties(userExtendDto, userExtend);
            userExtend.setId(extendId);
            userExtendService.saveOrUpdate(userExtend);
        }

        return ResponseUtils.success();
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
            //反射获取方法名
            String settingKey = declaredField.getName();
            userSetting.setSettingKey(settingKey);
            try {
                declaredField.setAccessible(true);
                //反射获取方法值
                userSetting.setSettingValue(String.valueOf(declaredField.get(notifyUserSettingDto)));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            userSetting.setCreateTime(LocalDateTime.now());
            userSetting.setUpdateTime(LocalDateTime.now());
            userSetting.setSettingGroup(UserSettingConstant.NOTIFYUSERSETTING);
            userSettings.add(userSetting);
        }
        this.saveBatch(userSettings);


        return ResponseUtils.success();
    }

    /**
     * 拜师收徒设置
     *
     * @param apprenticeSettingDto
     * @Param: [apprenticeSettingDto]
     * @return: com.wangfugui.apprentice.common.util.ResponseUtils
     * @Author: MaSiyi
     * @Date: 2021/12/6
     */
    @Override
    public ResponseUtils apprenticeSetting(ApprenticeSettingDto apprenticeSettingDto) {
        ArrayList<UserSetting> list = new ArrayList<>();
        //获取当前用户信息
        User userInfo = userService.getUserInfo();
        UserSetting setting = new UserSetting();
        setting.setUserId(userInfo.getId());
        setting.setSettingKey(UserSettingConstant.APPRENTICEVALUE);
        setting.setSettingValue(apprenticeSettingDto.getApprenticeValue());
        setting.setCreateTime(LocalDateTime.now());
        setting.setUpdateTime(LocalDateTime.now());
        setting.setSettingGroup(UserSettingConstant.APPRENTICEVALUE);
        list.add(setting);

        ApprenticeSettingExtendDto apprenticeSettingExtendDto = apprenticeSettingDto.getApprenticeSettingExtendDto();
        Field[] declaredFields = apprenticeSettingExtendDto.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {

            UserSetting userSetting = new UserSetting();
            userSetting.setUserId(userInfo.getId());
            userSetting.setSettingKey(declaredField.getName());
            try {
                declaredField.setAccessible(true);
                userSetting.setSettingValue(String.valueOf(declaredField.get(apprenticeSettingExtendDto)));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            userSetting.setCreateTime(LocalDateTime.now());
            userSetting.setUpdateTime(LocalDateTime.now());
            userSetting.setSettingGroup(UserSettingConstant.APPRENTICESETTING);
            list.add(userSetting);
        }
        this.saveBatch(list);

        return ResponseUtils.success();
    }

}
