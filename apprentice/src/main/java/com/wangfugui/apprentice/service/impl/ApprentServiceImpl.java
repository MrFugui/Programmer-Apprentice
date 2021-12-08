package com.wangfugui.apprentice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangfugui.apprentice.common.util.ResponseUtils;
import com.wangfugui.apprentice.dao.domain.Apprent;
import com.wangfugui.apprentice.dao.domain.User;
import com.wangfugui.apprentice.dao.mapper.ApprentMapper;
import com.wangfugui.apprentice.service.IApprentService;
import com.wangfugui.apprentice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author MrFugui
 * @since 2021-11-29
 */
@Service
public class ApprentServiceImpl extends ServiceImpl<ApprentMapper, Apprent> implements IApprentService {

    @Autowired
    private ApprentMapper apprentMapper;
    @Autowired
    private UserService userService;

    /**
     * 师傅列表
     *
     * @Param: [userId]
     * @return: com.wangfugui.apprentice.common.util.ResponseUtils
     * @Author: MaSiyi
     * @Date: 2021/11/30
     */
    @Override
    public ResponseUtils listMaster() {
        User userInfo = userService.getUserInfo();
        QueryWrapper<Apprent> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.lambda().eq(Apprent::getUserId, userInfo.getId());
        return ResponseUtils.success(apprentMapper.selectList(userQueryWrapper));
    }

    /**
     * 徒弟列表
     *
     * @Param: [userId]
     * @return: com.wangfugui.apprentice.common.util.ResponseUtils
     * @Author: MaSiyi
     * @Date: 2021/11/30
     */
    @Override
    public ResponseUtils listApprentice() {
        User userInfo = userService.getUserInfo();
        QueryWrapper<Apprent> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.lambda().eq(Apprent::getParentId, userInfo.getId());

        return ResponseUtils.success(apprentMapper.selectList(userQueryWrapper));
    }

}
