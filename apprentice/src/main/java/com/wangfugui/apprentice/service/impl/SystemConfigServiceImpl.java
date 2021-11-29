package com.wangfugui.apprentice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wangfugui.apprentice.dao.domain.SystemConfig;
import com.wangfugui.apprentice.dao.mapper.SystemConfigMapper;
import com.wangfugui.apprentice.service.ISystemConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统配置表 服务实现类
 * </p>
 *
 * @author MrFugui
 * @since 2021-11-29
 */
@Service
public class SystemConfigServiceImpl extends ServiceImpl<SystemConfigMapper, SystemConfig> implements ISystemConfigService {

    @Autowired
    private SystemConfigMapper systemConfigMapper;

    @Override
    public String getData(String key) {
        QueryWrapper<SystemConfig> systemConfigQueryWrapper = new QueryWrapper<>();
        systemConfigQueryWrapper.lambda().eq(SystemConfig::getKey, key);
        SystemConfig systemConfig = systemConfigMapper.selectOne(systemConfigQueryWrapper);
        return systemConfig.getValue();
    }
}
