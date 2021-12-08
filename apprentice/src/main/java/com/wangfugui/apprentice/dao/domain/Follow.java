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
 * 关注表
 * </p>
 *
 * @author MrFugui
 * @since 2021-12-08
 */
@ApiModel(value = "Follow对象", description = "关注表")
@Data
public class Follow implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("关注人")
    private Integer createUser;

    @ApiModelProperty("关注人名称")
    private String createUserName;

    @ApiModelProperty("被关注人")
    private Integer followUser;

    @ApiModelProperty("被关注人名称")
    private String followUserName;

    @ApiModelProperty("关注时间")
    private LocalDateTime followTime;



}
