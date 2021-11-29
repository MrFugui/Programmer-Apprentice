package com.wangfugui.apprentice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangfugui.apprentice.common.constant.ElasticSearchConstant;
import com.wangfugui.apprentice.common.util.ElasticSearchUtil;
import com.wangfugui.apprentice.common.util.ResponseUtils;
import com.wangfugui.apprentice.dao.domain.Blog;
import com.wangfugui.apprentice.dao.dto.PageParamDto;
import com.wangfugui.apprentice.dao.mapper.BlogMapper;
import com.wangfugui.apprentice.service.IBlogService;
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
    @Autowired
    private BlogMapper blogMapper;


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

    /**
     * 博客热榜
     *
     * @Param: []
     * @return: com.wangfugui.apprentice.common.util.ResponseUtils
     * @Author: MaSiyi
     * @Date: 2021/11/29
     */
    @Override
    public ResponseUtils hotBlog() {
        QueryWrapper<Blog> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.lambda().orderByDesc(Blog::getLookNumber);
        Page<Blog> blogPage = new Page<>(1, 10);
        Page<Blog> page = this.page(blogPage, objectQueryWrapper);
        return ResponseUtils.success(page);
    }

    /**
     * 最新博客
     *
     * @param pageParamDto
     * @Param:
     * @return:
     * @Author: MaSiyi
     * @Date: 2021/11/29
     */
    @Override
    public ResponseUtils newBlog(PageParamDto<Blog> pageParamDto) {
        QueryWrapper<Blog> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.lambda().orderByDesc(Blog::getCreateTime);

        Page<Blog> blogPage = new Page<>(pageParamDto.getPage(), pageParamDto.getSize());
        Page<Blog> page = this.page(blogPage, objectQueryWrapper);
        return ResponseUtils.success(page);
    }


}
