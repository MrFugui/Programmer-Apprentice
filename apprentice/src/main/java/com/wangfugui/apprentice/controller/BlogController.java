package com.wangfugui.apprentice.controller;


import com.wangfugui.apprentice.common.util.ResponseUtils;
import com.wangfugui.apprentice.dao.domain.Blog;
import com.wangfugui.apprentice.dao.dto.PageParamDto;
import com.wangfugui.apprentice.service.IBlogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 博客表 前端控制器
 * </p>
 *
 * @author MrFugui
 * @since 2021-11-25
 */
@RestController
@RequestMapping("/apprentice/blog")
@Api(tags = "博客管理")
public class BlogController extends BaseController<IBlogService, Blog> {

    @Autowired
    private IBlogService blogService;

    @GetMapping("/hotBlog")
    @ApiOperation("博客热榜")
    public ResponseUtils hotBlog() {
        return blogService.hotBlog();
    }

    @PostMapping("/newBlog")
    @ApiOperation("最新博客")
    public ResponseUtils newBlog(@RequestBody PageParamDto<Blog> pageParamDto) {
        return blogService.newBlog(pageParamDto);
    }


}

