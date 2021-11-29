package com.wangfugui.apprentice.controller;


import com.wangfugui.apprentice.dao.domain.SystemConfig;
import com.wangfugui.apprentice.service.ISystemConfigService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 系统配置表 前端控制器
 * </p>
 *
 * @author MrFugui
 * @since 2021-11-29
 */
@RestController
@RequestMapping("/apprentice/systemConfig")
public class SystemConfigController extends BaseController<ISystemConfigService, SystemConfig>{



}

