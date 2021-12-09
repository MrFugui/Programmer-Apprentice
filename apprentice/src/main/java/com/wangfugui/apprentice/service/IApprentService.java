package com.wangfugui.apprentice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wangfugui.apprentice.common.util.ResponseUtils;
import com.wangfugui.apprentice.dao.domain.Apprent;
import com.wangfugui.apprentice.dao.dto.SendAskDto;

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
    ResponseUtils listMaster();

    /** 徒弟列表
     * @Param: [userId]
     * @return: com.wangfugui.apprentice.common.util.ResponseUtils
     * @Author: MaSiyi
     * @Date: 2021/11/30
     */
    ResponseUtils listApprentice();

    /** 发送拜师收徒请求
     * @Param: [sendAskDto]
     * @return: com.wangfugui.apprentice.common.util.ResponseUtils
     * @Author: MaSiyi
     * @Date: 2021/12/9
     */
    ResponseUtils sendMasterApprenticeAsk(SendAskDto sendAskDto);
}
