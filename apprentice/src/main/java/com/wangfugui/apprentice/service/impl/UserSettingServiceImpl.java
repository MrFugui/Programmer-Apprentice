package com.wangfugui.apprentice.service.impl;

import com.wangfugui.apprentice.dao.domain.UserSetting;
import com.wangfugui.apprentice.dao.mapper.UserSettingMapper;
import com.wangfugui.apprentice.service.IUserSettingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
