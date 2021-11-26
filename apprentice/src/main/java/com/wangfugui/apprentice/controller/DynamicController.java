package com.wangfugui.apprentice.controller;


import com.wangfugui.apprentice.dao.domain.Dynamic;
import com.wangfugui.apprentice.service.IDynamicService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 动态表 前端控制器
 * </p>
 *
 * @author MrFugui
 * @since 2021-11-23
 */
@RestController
@RequestMapping("/apprentice/dynamic")
@Api("动态管理")
public class DynamicController extends BaseController<IDynamicService, Dynamic>{

}

