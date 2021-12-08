package com.wangfugui.apprentice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangfugui.apprentice.common.constant.NotifyConstant;
import com.wangfugui.apprentice.common.util.ResponseUtils;
import com.wangfugui.apprentice.dao.domain.Follow;
import com.wangfugui.apprentice.dao.domain.User;
import com.wangfugui.apprentice.dao.mapper.FollowMapper;
import com.wangfugui.apprentice.service.IFollowService;
import com.wangfugui.apprentice.service.INotifyService;
import com.wangfugui.apprentice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 关注表 服务实现类
 * </p>
 *
 * @author MrFugui
 * @since 2021-12-08
 */
@Service
public class FollowServiceImpl extends ServiceImpl<FollowMapper, Follow> implements IFollowService {


    @Autowired
    private INotifyService notifyService;
    @Autowired
    private UserService userService;
    @Autowired
    private FollowMapper followMapper;

    @Override
    public boolean save(Follow entity) {
        User userInfo = userService.getUserInfo();
        entity.setCreateUser(userInfo.getId());
        entity.setCreateUserName(userInfo.getUsername());
        entity.setFollowTime(LocalDateTime.now());

        //添加关注通知
        notifyService.addFollowNotify(entity, NotifyConstant.NotifyType.FOLLOW);
        return super.save(entity);
    }

    /**
     * 关注列表
     *
     * @Param: []
     * @return: com.wangfugui.apprentice.common.util.ResponseUtils
     * @Author: MaSiyi
     * @Date: 2021/12/8
     */
    @Override
    public ResponseUtils listFollowing() {
        User userInfo = userService.getUserInfo();

        QueryWrapper<Follow> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.lambda().eq(Follow::getCreateUser, userInfo.getId());
        return ResponseUtils.success(followMapper.selectList(userQueryWrapper));
    }

    /**
     * 粉丝列表
     *
     * @Param: []
     * @return: com.wangfugui.apprentice.common.util.ResponseUtils
     * @Author: MaSiyi
     * @Date: 2021/12/8
     */
    @Override
    public ResponseUtils listFollowers() {
        User userInfo = userService.getUserInfo();
        QueryWrapper<Follow> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.lambda().eq(Follow::getFollowUser, userInfo.getId());
        return ResponseUtils.success(followMapper.selectList(userQueryWrapper));
    }
}
