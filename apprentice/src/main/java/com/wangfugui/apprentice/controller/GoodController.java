package com.wangfugui.apprentice.controller;


import com.wangfugui.apprentice.dao.domain.Good;
import com.wangfugui.apprentice.service.IGoodService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
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
public class GoodController extends BaseController<IGoodService,Good>{

    @Autowired
    private IGoodService goodService;

}

