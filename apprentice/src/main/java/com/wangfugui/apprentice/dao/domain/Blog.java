package com.wangfugui.apprentice.dao.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 博客表
 * </p>
 *
 * @author MrFugui
 * @since 2021-11-25
 */
@Data
@ApiModel(value = "Blog对象", description = "博客表")
public class Blog implements Serializable {

    private Integer id;

    @ApiModelProperty("博客标题")
    private String blogTitle;

    @ApiModelProperty("博客内容")
    private String blogText;

    @ApiModelProperty("图片id")
    private Integer fileId;

    @ApiModelProperty("点赞数量")
    private Integer goodNumber;

    @ApiModelProperty("评论数量")
    private Integer talkNumber;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("是否删除")
    private Boolean deleteFlag;

    @ApiModelProperty("创建人")
    private Integer createUser;

    @ApiModelProperty("浏览量")
    private Integer lookNumber;

    @ApiModelProperty("收藏量")
    private Integer starNumber;

    @ApiModelProperty("0原创1转载")
    private Boolean creation;

    @ApiModelProperty("0未审核1审核中2审核失败3已发布")
    private Integer blogStatus;

    @ApiModelProperty("版权地址")
    private String copyrightLink;

    @ApiModelProperty("版权地址")
    private String elsearchId;



}
