package com.wangfugui.apprentice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangfugui.apprentice.common.constant.NotifyConstant;
import com.wangfugui.apprentice.common.exception.ApprenticeException;
import com.wangfugui.apprentice.common.util.ResponseUtils;
import com.wangfugui.apprentice.dao.domain.Good;
import com.wangfugui.apprentice.dao.mapper.GoodMapper;
import com.wangfugui.apprentice.service.IBlogService;
import com.wangfugui.apprentice.service.IDynamicService;
import com.wangfugui.apprentice.service.IGoodService;
import com.wangfugui.apprentice.service.INotifyService;
import com.wangfugui.apprentice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 点赞表 服务实现类
 * </p>
 *
 * @author MrFugui
 * @since 2021-11-23
 */
@Service
public class GoodServiceImpl extends ServiceImpl<GoodMapper, Good> implements IGoodService {

    @Autowired
    private UserService userService;
    @Autowired
    private INotifyService notifyService;
    @Autowired
    private IBlogService blogService;
    @Autowired
    private IDynamicService dynamicService;


    /**
     * 点赞功能
     *
     * @param good
     * @Param: [good]
     * @return: com.wangfugui.apprentice.common.util.ResponseUtils
     * @Author: MaSiyi
     * @Date: 2021/12/6
     */
    @Override
    public ResponseUtils good(Good good) {

        //博客id
        int blogId = good.getBlogId() == null ? 0 : good.getBlogId();
        //动态id
        int dynamicId = good.getDynamicId() == null ? 0 : good.getDynamicId();
        //两个都没选
        if (blogId == 0 && dynamicId == 0) {
            throw new ApprenticeException("请选择博客或者动态");
        }
        //两个都选了
        if (blogId != 0 && dynamicId != 0) {
            throw new ApprenticeException("请选择一个博客或者动态");
        }

        if (blogId != 0) {
            good.setBlogId(blogId);
            notifyService.addBlogNotify(blogService.getById(blogId), NotifyConstant.NotifyType.GOOD);
        } else {
            good.setDynamicId(dynamicId);
            notifyService.addDynamicNotify(dynamicService.getById(dynamicId), NotifyConstant.NotifyType.GOOD);
        }

        good.setCreateTime(LocalDateTime.now());
        good.setCreateUser(userService.getUserInfo().getId());

        return ResponseUtils.success();
    }
}
