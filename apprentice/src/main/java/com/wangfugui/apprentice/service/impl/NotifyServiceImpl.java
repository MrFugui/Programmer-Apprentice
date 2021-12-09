package com.wangfugui.apprentice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangfugui.apprentice.common.constant.NotifyConstant;
import com.wangfugui.apprentice.common.exception.ApprenticeException;
import com.wangfugui.apprentice.dao.domain.Blog;
import com.wangfugui.apprentice.dao.domain.Dynamic;
import com.wangfugui.apprentice.dao.domain.Follow;
import com.wangfugui.apprentice.dao.domain.Notify;
import com.wangfugui.apprentice.dao.domain.Text;
import com.wangfugui.apprentice.dao.domain.User;
import com.wangfugui.apprentice.dao.mapper.NotifyMapper;
import com.wangfugui.apprentice.service.IBlogService;
import com.wangfugui.apprentice.service.IDynamicService;
import com.wangfugui.apprentice.service.INotifyService;
import com.wangfugui.apprentice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;

/**
 * <p>
 * 通知表 服务实现类
 * </p>
 *
 * @author MrFugui
 * @since 2021-11-30
 */
@Service
public class NotifyServiceImpl extends ServiceImpl<NotifyMapper, Notify> implements INotifyService {

    @Autowired
    private IBlogService blogService;
    @Autowired
    private IDynamicService dynamicService;
    @Autowired
    private UserService userService;

    /**
     * 系统
     */
    static final Integer USERIDSYSTEM = 0;

    /**
     * 增加博客通知
     *
     * @param blog
     * @Param: []
     * @return: java.lang.String
     * @Author: MaSiyi
     * @Date: 2021/12/6
     */
    @Override
    public Boolean addBlogNotify(Blog blog, NotifyConstant.NotifyType notifyType) {
        if (ObjectUtils.isEmpty(blog)) {
            throw new ApprenticeException("博客为空");
        }
        User userInfo = userService.getUserInfo();
        int toUserId;
        Notify notify = new Notify();
        notify.setType(notifyType.getName());
        String value = notifyType.getValue();
        notify.setNotifyTitle(value + "通知");
        String blogTitle = blog.getBlogTitle();
        String show;
        if (blogTitle.length() > 10) {
            show = blogTitle.substring(0, 10) + "...";
        } else {
            show = blogTitle;
        }
        notify.setNotifyValue(userInfo.getUsername() + value + "了您的" +
                show);
        toUserId = blog.getCreateUser();
        notify.setUserId(userInfo.getId());
        notify.setCreateTime(LocalDateTime.now());
        notify.setTouserId(toUserId);
        notify.setNotifyStatus(NotifyConstant.NotifyStatus.NOREAD.getName());

        return this.save(notify);
    }

    /**
     * 增加动态通知
     *
     * @param dynamic
     * @Param: []
     * @return: java.lang.String
     * @Author: MaSiyi
     * @Date: 2021/12/6
     */
    @Override
    public Boolean addDynamicNotify(Dynamic dynamic, NotifyConstant.NotifyType notifyType) {
        if (ObjectUtils.isEmpty(dynamic)) {
            throw new ApprenticeException("动态为空");
        }
        User userInfo = userService.getUserInfo();
        int toUserId;
        Notify notify = new Notify();
        notify.setType(notifyType.getName());
        String value = notifyType.getValue();
        notify.setNotifyTitle(value + "通知");
        String dynamicText = dynamic.getDynamicText();
        String show;
        if (dynamicText.length() > 10) {
            show = dynamicText.substring(0, 10) + "...";
        } else {
            show = dynamicText;
        }
        notify.setNotifyValue(userInfo.getUsername() + value + "了您的" + show);
        toUserId = dynamic.getCreateUser();
        notify.setUserId(userInfo.getId());
        notify.setCreateTime(LocalDateTime.now());
        notify.setTouserId(toUserId);
        notify.setNotifyStatus(NotifyConstant.NotifyStatus.NOREAD.getName());

        return this.save(notify);
    }

    @Override
    public  Boolean checkChoose(Text entity) {

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
        return true;
    }

    /**
     * 添加关注通知
     *
     * @param follow
     * @Param: [follow]
     * @return: java.lang.Boolean
     * @Author: MaSiyi
     * @Date: 2021/12/8
     */
    @Override
    public Boolean addFollowNotify(Follow follow,NotifyConstant.NotifyType notifyType) {


        Notify notify = new Notify();
        notify.setUserId(0);
        notify.setCreateTime(LocalDateTime.now());

        notify.setNotifyStatus(0);

        notify.setType(notifyType.getName());
        String value = notifyType.getValue();
        notify.setNotifyTitle(value + "通知");
        notify.setNotifyValue(follow.getCreateUserName()+"关注了您");

        notify.setTouserId(follow.getFollowUser());
        notify.setNotifyStatus(NotifyConstant.NotifyStatus.NOREAD.getName());

        return super.save(notify);
    }

    /**
     * 拜师收徒通知
     *
     * @param userId
     * @param notifyType
     * @Param:
     * @return:
     * @Author: MaSiyi
     * @Date: 2021/12/9
     */
    @Override
    public Boolean addMasterApprenticeNotify(Integer userId, NotifyConstant.NotifyType notifyType) {
        Notify notify = new Notify();
        notify.setType(notifyType.getName());
        notify.setNotifyTitle(notifyType.getValue()+"通知");
        notify.setNotifyValue("您收到了一条"+notifyType.getValue()+"请求");
        notify.setUserId(USERIDSYSTEM);
        notify.setTouserId(userId);
        notify.setCreateTime(LocalDateTime.now());
        notify.setNotifyStatus(NotifyConstant.NotifyStatus.NOREAD.getName());

        return super.save(notify);
    }
}
