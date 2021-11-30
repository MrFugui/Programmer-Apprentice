package com.wangfugui.apprentice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wangfugui.apprentice.common.util.ResponseUtils;
import com.wangfugui.apprentice.dao.domain.Apprent;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author MrFugui
 * @since 2021-11-29
 */
public interface IApprentService extends IService<Apprent> {


    /** 师傅列表
     * @Param: [userId]
     * @return: com.wangfugui.apprentice.common.util.ResponseUtils
     * @Author: MaSiyi
     * @Date: 2021/11/30
     */
    ResponseUtils listMaster(String userId);

    /** 徒弟列表
     * @Param: [userId]
     * @return: com.wangfugui.apprentice.common.util.ResponseUtils
     * @Author: MaSiyi
     * @Date: 2021/11/30
     */
    ResponseUtils listApprentice(String userId);
}
