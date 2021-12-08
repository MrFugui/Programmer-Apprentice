package com.wangfugui.apprentice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangfugui.apprentice.common.constant.NotifyConstant;
import com.wangfugui.apprentice.dao.domain.Collection;
import com.wangfugui.apprentice.dao.mapper.CollectionMapper;
import com.wangfugui.apprentice.service.IBlogService;
import com.wangfugui.apprentice.service.ICollectionService;
import com.wangfugui.apprentice.service.INotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 收藏表 服务实现类
 * </p>
 *
 * @author MrFugui
 * @since 2021-12-08
 */
@Service
public class CollectionServiceImpl extends ServiceImpl<CollectionMapper, Collection> implements ICollectionService {

    @Autowired
    private INotifyService notifyService;
    @Autowired
    private IBlogService blogService;


    @Override
    public boolean save(Collection entity) {
        int blogId = entity.getBlogId();
        //添加通知
        notifyService.addBlogNotify(blogService.getById(blogId), NotifyConstant.NotifyType.COLLECTION);

        return super.save(entity);

    }
}
