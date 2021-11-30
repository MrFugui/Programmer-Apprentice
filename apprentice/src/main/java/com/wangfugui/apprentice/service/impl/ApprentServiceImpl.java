package com.wangfugui.apprentice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangfugui.apprentice.common.util.ResponseUtils;
import com.wangfugui.apprentice.dao.domain.Apprent;
import com.wangfugui.apprentice.dao.mapper.ApprentMapper;
import com.wangfugui.apprentice.service.IApprentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


    /**
     * 师傅列表
     *
     * @param userId
     * @Param: [userId]
     * @return: com.wangfugui.apprentice.common.util.ResponseUtils
     * @Author: MaSiyi
     * @Date: 2021/11/30
     */
    @Override
    public ResponseUtils listMaster(String userId) {
        QueryWrapper<Apprent> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.lambda().eq(Apprent::getUserId, userId);
        List<Apprent> apprents = apprentMapper.selectList(userQueryWrapper);
        return ResponseUtils.success(apprents);
    }

    /**
     * 徒弟列表
     *
     * @param userId
     * @Param: [userId]
     * @return: com.wangfugui.apprentice.common.util.ResponseUtils
     * @Author: MaSiyi
     * @Date: 2021/11/30
     */
    @Override
    public ResponseUtils listApprentice(String userId) {
        QueryWrapper<Apprent> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.lambda().eq(Apprent::getParentId, userId);
        List<Apprent> apprents = apprentMapper.selectList(userQueryWrapper);

        return ResponseUtils.success(apprents);
    }

}
