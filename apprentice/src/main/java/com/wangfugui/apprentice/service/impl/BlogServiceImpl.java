package com.wangfugui.apprentice.service.impl;

import com.wangfugui.apprentice.common.constant.ElasticSearchConstant;
import com.wangfugui.apprentice.common.util.ElasticSearchUtil;
import com.wangfugui.apprentice.dao.domain.Blog;
import com.wangfugui.apprentice.dao.mapper.BlogMapper;
import com.wangfugui.apprentice.service.IBlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * <p>
 * 博客表 服务实现类
 * </p>
 *
 * @author MrFugui
 * @since 2021-11-25
 */
@Service
@Slf4j
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements IBlogService {

    @Autowired
    private ElasticSearchUtil elasticSearchUtil;

    @Override
    public boolean save(Blog entity) {

        //保存到es中
        try {
            IndexResponse indexResponse = elasticSearchUtil.addEntity(entity, ElasticSearchConstant.TEXT_INDEX);
            entity.setElsearchId(indexResponse.getId());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return super.save(entity);
    }
}
