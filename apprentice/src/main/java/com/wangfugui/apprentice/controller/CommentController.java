package com.wangfugui.apprentice.controller;


import com.wangfugui.apprentice.dao.domain.Comment;
import com.wangfugui.apprentice.service.ICommentService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 评论表 前端控制器
 * </p>
 *
 * @author MrFugui
 * @since 2021-11-23
 */
@RestController
@RequestMapping("/apprentice/comment")
@Api(tags = "评论管理")
public class CommentController extends BaseController<ICommentService, Comment> {



}

