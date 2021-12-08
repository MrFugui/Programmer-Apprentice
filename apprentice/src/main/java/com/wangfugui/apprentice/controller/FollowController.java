package com.wangfugui.apprentice.controller;


import com.wangfugui.apprentice.dao.domain.Follow;
import com.wangfugui.apprentice.service.IFollowService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 关注表 前端控制器
 * </p>
 *
 * @author MrFugui
 * @since 2021-12-08
 */
@RestController
@RequestMapping("/apprentice/follow")
public class FollowController extends BaseController<IFollowService, Follow>{

}

