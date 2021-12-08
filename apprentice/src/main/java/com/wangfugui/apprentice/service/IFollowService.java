package com.wangfugui.apprentice.service;

import com.wangfugui.apprentice.common.util.ResponseUtils;
import com.wangfugui.apprentice.dao.domain.Follow;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 关注表 服务类
 * </p>
 *
 * @author MrFugui
 * @since 2021-12-08
 */
public interface IFollowService extends IService<Follow> {

    /** 关注列表
     * @Param: []
     * @return: com.wangfugui.apprentice.common.util.ResponseUtils
     * @Author: MaSiyi
     * @Date: 2021/12/8
     */
    ResponseUtils listFollowing();

    /** 粉丝列表
     * @Param: []
     * @return: com.wangfugui.apprentice.common.util.ResponseUtils
     * @Author: MaSiyi
     * @Date: 2021/12/8
     */
    ResponseUtils listFollowers();
}
