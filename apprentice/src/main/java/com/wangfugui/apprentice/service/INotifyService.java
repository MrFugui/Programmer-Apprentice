package com.wangfugui.apprentice.service;

import com.wangfugui.apprentice.common.constant.NotifyConstant;
import com.wangfugui.apprentice.dao.domain.Blog;
import com.wangfugui.apprentice.dao.domain.Dynamic;
import com.wangfugui.apprentice.dao.domain.Follow;
import com.wangfugui.apprentice.dao.domain.Notify;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wangfugui.apprentice.dao.domain.Text;

/**
 * <p>
 * 通知表 服务类
 * </p>
 *
 * @author MrFugui
 * @since 2021-11-30
 */
public interface INotifyService extends IService<Notify> {

    /**
     * 增加博客通知
     *
     * @Param: []
     * @return: java.lang.String
     * @Author: MaSiyi
     * @Date: 2021/12/6
     */
    Boolean addBlogNotify(Blog blog, NotifyConstant.NotifyType notifyType);
    /**
     * 增加动态通知
     *
     * @Param: []
     * @return: java.lang.String
     * @Author: MaSiyi
     * @Date: 2021/12/6
     */
    Boolean addDynamicNotify(Dynamic dynamic, NotifyConstant.NotifyType notifyType);

    /** 检查输入
     * @Param: [entity]
     * @return: java.lang.Boolean
     * @Author: MaSiyi
     * @Date: 2021/12/6
     */
    Boolean checkChoose(Text entity);


    /** 添加关注通知
     * @Param: [follow]
     * @return: java.lang.Boolean
     * @Author: MaSiyi
     * @Date: 2021/12/8
     */
    Boolean addFollowNotify(Follow follow,NotifyConstant.NotifyType notifyType);

    /**
     * 拜师收徒通知
     *
     * @Param:
     * @return:
     * @Author: MaSiyi
     * @Date: 2021/12/9
     */
    Boolean addMasterApprenticeNotify(Integer userId,NotifyConstant.NotifyType notifyType);

}
