package com.wangfugui.apprentice.dao.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author MaSiyi
 * @version 1.0.0 2021/12/4
 * @since JDK 1.8.0
 */
@Data
public class NotifyUserSettingDto {

    /**
     * 收徒申请
     */
    @ApiModelProperty("收徒申请")
    Boolean apprenticeApplication;
    /**
     * 拜师申请
     */
    @ApiModelProperty("拜师申请")
    Boolean masterApplication;
    /**
     * 私信通知
     */
    @ApiModelProperty("私信通知")
    Boolean privateMessageReception;
    /**
     * 点赞
     */
    @ApiModelProperty("点赞")
    Boolean likeNotification;
    /**
     * 评论
     */
    @ApiModelProperty("评论")
    Boolean commentNotification;
    /**
     * 收藏
     */
    @ApiModelProperty("收藏")
    Boolean collectionNotice;
    /**
     * 关注
     */
    @ApiModelProperty("关注")
    Boolean followNotifications;

}
