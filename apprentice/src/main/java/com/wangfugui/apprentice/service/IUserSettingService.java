package com.wangfugui.apprentice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wangfugui.apprentice.common.util.ResponseUtils;
import com.wangfugui.apprentice.dao.domain.UserSetting;
import com.wangfugui.apprentice.dao.dto.ApprenticeSettingDto;
import com.wangfugui.apprentice.dao.dto.NotifyUserSettingDto;
import com.wangfugui.apprentice.dao.dto.UserExtendDto;

/**
 * <p>
 * 用户设置表 服务类
 * </p>
 *
 * @author MrFugui
 * @since 2021-11-30
 */
public interface IUserSettingService extends IService<UserSetting> {

    /** 更新用户拓展信息
     * @Param: [userExtendDto]
     * @return: com.wangfugui.apprentice.common.util.ResponseUtils
     * @Author: MaSiyi
     * @Date: 2021/12/4
     */
    ResponseUtils updateUserInfo(UserExtendDto userExtendDto);

    /** 消息接收
     * @Param: [notifyUserSettingDto]
     * @return: com.wangfugui.apprentice.common.util.ResponseUtils
     * @Author: MaSiyi
     * @Date: 2021/12/4
     */
    ResponseUtils notifyUserSetting(NotifyUserSettingDto notifyUserSettingDto);

    /** 拜师收徒设置
     * @Param: [apprenticeSettingDto]
     * @return: com.wangfugui.apprentice.common.util.ResponseUtils
     * @Author: MaSiyi
     * @Date: 2021/12/6
     */
    ResponseUtils apprenticeSetting(ApprenticeSettingDto apprenticeSettingDto);
}
