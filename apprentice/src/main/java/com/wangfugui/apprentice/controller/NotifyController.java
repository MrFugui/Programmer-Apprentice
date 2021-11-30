package com.wangfugui.apprentice.controller;


import com.wangfugui.apprentice.dao.domain.Notify;
import com.wangfugui.apprentice.service.INotifyService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 通知表 前端控制器
 * </p>
 *
 * @author MrFugui
 * @since 2021-11-30
 */
@RestController
@RequestMapping("/apprentice/notify")
@Api(tags = "通知管理")
public class NotifyController extends BaseController<INotifyService, Notify>{

}

