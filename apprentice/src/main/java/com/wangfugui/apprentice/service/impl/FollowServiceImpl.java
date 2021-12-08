package com.wangfugui.apprentice.service.impl;

import com.wangfugui.apprentice.dao.domain.Follow;
import com.wangfugui.apprentice.dao.mapper.FollowMapper;
import com.wangfugui.apprentice.service.IFollowService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
