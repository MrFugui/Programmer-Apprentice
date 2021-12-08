package com.wangfugui.apprentice.service.impl;

import com.wangfugui.apprentice.dao.domain.Collection;
import com.wangfugui.apprentice.dao.mapper.CollectionMapper;
import com.wangfugui.apprentice.service.ICollectionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

}
