package com.wangfugui.apprentice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangfugui.apprentice.common.constant.NotifyConstant;
import com.wangfugui.apprentice.common.exception.ApprenticeException;
import com.wangfugui.apprentice.dao.domain.Blog;
import com.wangfugui.apprentice.dao.domain.Comment;
import com.wangfugui.apprentice.dao.domain.Dynamic;
import com.wangfugui.apprentice.dao.domain.Notify;
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

        //博客id
        int blogId = entity.getBlogId() == null ? 0 : entity.getBlogId();
        //动态id
        int dynamicId = entity.getDynamicId() == null ? 0 : entity.getDynamicId();
        //两个都没选
        if (blogId == 0 && dynamicId == 0) {
            throw new ApprenticeException("请选择博客或者动态");
        }
        //两个都选了
        if (blogId != 0 && dynamicId != 0) {
            throw new ApprenticeException("请选择一个博客或者动态");
        }

        entity.setCreateTime(LocalDateTime.now());
        Integer userId = userInfo.getId();
        entity.setCreateUser(userId);

        //发送通知
        Notify notify = new Notify();
        notify.setType(NotifyConstant.NotifyType.COMMENT.getName());
        String value = NotifyConstant.NotifyType.COMMENT.getValue();
        notify.setNotifyTitle(value + "通知");
        Blog blog;
        Dynamic dynamic;
        int toUserId;
        if (blogId != 0) {
            blog = blogService.getById(blogId);
            notify.setNotifyValue(userInfo.getUsername() + value + "了您的" +
                    blog.getBlogTitle());
            toUserId = blog.getCreateUser();
        } else {
            dynamic = dynamicService.getById(dynamicId);

            String dynamicText = dynamic.getDynamicText();
            String show;
            if (dynamicText.length() > 10) {
                show = dynamicText.substring(0, 10) + "...";
            } else {
                show = dynamicText;
            }
            notify.setNotifyValue(userInfo.getUsername() + value + "了您的" + show);
            toUserId = dynamic.getCreateUser();
        }
        notify.setUserId(userId);
        notify.setCreateTime(LocalDateTime.now());
        notify.setTouserId(toUserId);
        notify.setNotifyStatus(NotifyConstant.NotifyStatus.Read.getName());


        notifyService.save(notify);
        return super.save(entity);
    }
}
