package com.wangfugui.apprentice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangfugui.apprentice.common.constant.NotifyConstant;
import com.wangfugui.apprentice.dao.domain.Comment;
import com.wangfugui.apprentice.dao.domain.User;
import com.wangfugui.apprentice.dao.mapper.CommentMapper;
import com.wangfugui.apprentice.service.IBlogService;
import com.wangfugui.apprentice.service.ICommentService;
import com.wangfugui.apprentice.service.IDynamicService;
import com.wangfugui.apprentice.service.INotifyService;
import com.wangfugui.apprentice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 评论表 服务实现类
 * </p>
 *
 * @author MrFugui
 * @since 2021-11-23
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

    @Autowired
    private UserService userService;
    @Autowired
    private INotifyService notifyService;
    @Autowired
    private IBlogService blogService;
    @Autowired
    private IDynamicService dynamicService;

    @Override
    public boolean save(Comment entity) {
        User userInfo = userService.getUserInfo();

        boolean aBoolean = notifyService.checkChoose(entity);
        if (aBoolean) {

            entity.setCreateTime(LocalDateTime.now());
            Integer userId = userInfo.getId();
            entity.setCreateUser(userId);
            int blogId = entity.getBlogId();
            int dynamicId = entity.getDynamicId();
            if (blogId != 0) {
                //发送通知
                notifyService.addBlogNotify(blogService.getById(blogId), NotifyConstant.NotifyType.COMMENT);
            } else {
                //发送通知
                notifyService.addDynamicNotify(dynamicService.getById(dynamicId), NotifyConstant.NotifyType.COMMENT);
            }
        }
        return super.save(entity);
    }
}
