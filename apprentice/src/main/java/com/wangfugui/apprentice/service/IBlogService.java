package com.wangfugui.apprentice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wangfugui.apprentice.common.util.ResponseUtils;
import com.wangfugui.apprentice.dao.domain.Blog;
import com.wangfugui.apprentice.dao.dto.PageParamDto;

/**
 * <p>
 * 博客表 服务类
 * </p>
 *
 * @author MrFugui
 * @since 2021-11-25
 */
public interface IBlogService extends IService<Blog> {

    /** 博客热榜
     * @Param: []
     * @return: com.wangfugui.apprentice.common.util.ResponseUtils
     * @Author: MaSiyi
     * @Date: 2021/11/29
     */
    ResponseUtils hotBlog();

    /** 最新博客
     * @Param:
     * @return:
     * @Author: MaSiyi
     * @Date: 2021/11/29
     * @param pageParamDto
     */
    ResponseUtils newBlog(PageParamDto<Blog> pageParamDto);

}
