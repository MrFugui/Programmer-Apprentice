package com.wangfugui.apprentice.controller;


import com.wangfugui.apprentice.dao.domain.Collection;
import com.wangfugui.apprentice.service.ICollectionService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 收藏表 前端控制器
 * </p>
 *
 * @author MrFugui
 * @since 2021-12-08
 */
@RestController
@RequestMapping("/apprentice/collection")
@Api(tags = "收藏功能")
public class CollectionController extends BaseController<ICollectionService, Collection>{

}

