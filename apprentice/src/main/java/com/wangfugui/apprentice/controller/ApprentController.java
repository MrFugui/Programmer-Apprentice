package com.wangfugui.apprentice.controller;


import com.wangfugui.apprentice.common.util.ResponseUtils;
import com.wangfugui.apprentice.service.IApprentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author MrFugui
 * @since 2021-11-29
 */
@Controller
@RequestMapping("/apprentice/apprent")
public class ApprentController {

    @Autowired
    private IApprentService apprentService;


    @GetMapping("/listMaster")
    @ApiOperation("师傅列表")
    public ResponseUtils listMaster(@RequestParam String userId) {
        return apprentService.listMaster(userId);
    }

    @GetMapping("/listApprentice")
    @ApiOperation("徒弟列表")
    public ResponseUtils listApprentice(@RequestParam String userId) {
        return apprentService.listApprentice(userId);
    }
}

