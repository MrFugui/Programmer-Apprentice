package com.wangfugui.apprentice.service;

import com.wangfugui.apprentice.common.util.ResponseUtils;
import com.wangfugui.apprentice.dao.domain.Good;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 点赞表 服务类
 * </p>
 *
 * @author MrFugui
 * @since 2021-11-23
 */
public interface IGoodService extends IService<Good> {

    /** 点赞功能
     * @Param: [good]
     * @return: com.wangfugui.apprentice.common.util.ResponseUtils
     * @Author: MaSiyi
     * @Date: 2021/12/6
     */
    ResponseUtils good(Good good);
}
