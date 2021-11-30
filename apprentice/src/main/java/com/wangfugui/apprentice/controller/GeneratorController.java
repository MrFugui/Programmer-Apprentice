package com.wangfugui.apprentice.controller;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.wangfugui.apprentice.common.util.ResponseUtils;
import com.wangfugui.apprentice.dao.dto.GeneratorDto;
import com.wangfugui.apprentice.service.ISystemConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

/**
 * @author MaSiyi
 * @version 1.0.0 2021/11/29
 * @since JDK 1.8.0
 */
@Api(tags = "代码生成器")
@RestController
@RequestMapping("/generator")
public class GeneratorController {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    @Autowired
    private ISystemConfigService systemConfigService;


    @PostMapping("/generator")
    @ApiOperation("生成代码")
    public ResponseUtils generator(@RequestBody GeneratorDto generatorDto) {

        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author(generatorDto.getAuthName()) // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .disableOpenDir()
                            .commentDate("yyyy-MM-dd")
                            .outputDir(generatorDto.getDirUrl()); // 指定输出目录

                })
                .packageConfig(builder -> {
                    builder.parent("com.wangfugui") // 设置父包名
                            .moduleName("apprentice") // 设置父包模块名
                            .entity("dao.domain")
                            .service("service")
                            .serviceImpl("service.impl")
                            .mapper("dao.mapper")
                            .controller("controller")
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, systemConfigService.getData("mapperDir"))); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude(generatorDto.getTableName()); // 设置需要生成的表名
                })
                .execute();

        return ResponseUtils.success("生成完成");
    }


}
