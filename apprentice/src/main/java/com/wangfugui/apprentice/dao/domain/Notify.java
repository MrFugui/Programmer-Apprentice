package com.wangfugui.apprentice.dao.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 通知表
 * </p>
 *
 * @author MrFugui
 * @since 2021-11-30
 */
@ApiModel(value = "Notify对象", description = "通知表")
@Data
public class Notify implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("通知类型")
    private String type;

    @ApiModelProperty("通知标题")
    private String notifyTitle;

    @ApiModelProperty("通知内容")
    private String notifyValue;

    @ApiModelProperty("用户id")
    private Integer userId;

    @ApiModelProperty("发送至用户id")
    private Integer touserId;

    @ApiModelProperty("通知时间")
    private LocalDateTime createTime;

    @ApiModelProperty("查看时间")
    private LocalDateTime readTime;

    @ApiModelProperty("通知状态1已读0未读")
    private Integer notifyStatus;


}
