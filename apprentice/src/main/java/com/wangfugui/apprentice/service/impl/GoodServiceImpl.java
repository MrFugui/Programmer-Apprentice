package com.wangfugui.apprentice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangfugui.apprentice.common.util.ResponseUtils;
import com.wangfugui.apprentice.dao.domain.Good;
import com.wangfugui.apprentice.dao.mapper.GoodMapper;
import com.wangfugui.apprentice.service.IGoodService;
import com.wangfugui.apprentice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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


        Integer blogId = good.getBlogId();
        if (ObjectUtils.isEmpty(blogId)) {
            good.setBlogId(blogId);
        }
        Integer dynamicId = good.getDynamicId();
        if (ObjectUtils.isEmpty(dynamicId)) {
            good.setDynamicId(dynamicId);
        }
        good.setCreateTime(LocalDateTime.now());
        good.setCreateUser(userService.getUserInfo().getId());
        this.save(good);
        return ResponseUtils.success();
    }
}
