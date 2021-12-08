package com.wangfugui.apprentice.controller;


import com.wangfugui.apprentice.common.util.ResponseUtils;
import com.wangfugui.apprentice.dao.domain.Follow;
import com.wangfugui.apprentice.service.IFollowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
@Api(tags = "关注功能")
public class FollowController extends BaseController<IFollowService, Follow>{

    @Autowired
    private IFollowService followService;


    @GetMapping("/listFollowing")
    @ApiOperation("关注列表")
    public ResponseUtils listFollowing() {
        return followService.listFollowing();
    }

    @GetMapping("/listFollowers")
    @ApiOperation("粉丝列表")
    public ResponseUtils listFollowers() {
        return followService.listFollowers();
    }
}

