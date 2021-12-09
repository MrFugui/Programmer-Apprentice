package com.wangfugui.apprentice.controller;


import com.wangfugui.apprentice.common.util.ResponseUtils;
import com.wangfugui.apprentice.dao.dto.SendAskDto;
import com.wangfugui.apprentice.service.IApprentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author MrFugui
 * @since 2021-11-29
 */
@RestController
@RequestMapping("/apprentice/apprent")
@Api(tags = "师徒管理")
public class ApprentController {

    @Autowired
    private IApprentService apprentService;


    @GetMapping("/listMaster")
    @ApiOperation("师傅列表")
    public ResponseUtils listMaster() {
        return apprentService.listMaster();
    }

    @GetMapping("/listApprentice")
    @ApiOperation("徒弟列表")
    public ResponseUtils listApprentice() {
        return apprentService.listApprentice();
    }

    @PostMapping("/sendMasterApprenticeAsk")
    @ApiOperation("发送拜师收徒请求")
    public ResponseUtils sendMasterApprenticeAsk(@RequestBody SendAskDto sendAskDto) {

        return apprentService.sendMasterApprenticeAsk(sendAskDto);

    }
}

