package com.wangfugui.apprentice.controller;


import com.wangfugui.apprentice.common.util.ResponseUtils;
import com.wangfugui.apprentice.dao.domain.Good;
import com.wangfugui.apprentice.service.IGoodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 点赞表 前端控制器
 * </p>
 *
 * @author MrFugui
 * @since 2021-11-23
 */
@RestController
@RequestMapping("/apprentice/good")
@Api(tags = "点赞管理")
public class GoodController {

    @Autowired
    private IGoodService goodService;

    @ApiOperation("点赞")
    @PostMapping("/good")
    public ResponseUtils good(@RequestBody Good good) {
        return goodService.good(good);
    }

}

