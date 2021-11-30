package com.wangfugui.apprentice.service;

import com.wangfugui.apprentice.dao.domain.SystemConfig;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 系统配置表 服务类
 * </p>
 *
 * @author MrFugui
 * @since 2021-11-29
 */
public interface ISystemConfigService extends IService<SystemConfig> {

    /** 获取配置信息
     * @Param: [key]
     * @return: java.lang.String
     * @Author: MaSiyi
     * @Date: 2021/11/29
     */
    String getData(String key);

}
