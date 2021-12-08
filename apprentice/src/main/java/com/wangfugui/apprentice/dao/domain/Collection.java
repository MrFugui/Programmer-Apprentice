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
 * 收藏表
 * </p>
 *
 * @author MrFugui
 * @since 2021-12-08
 */
@ApiModel(value = "Collection对象", description = "收藏表")
@Data
public class Collection implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("博客id")
    private Integer blogId;

    @ApiModelProperty("收藏人")
    private String createUser;

    @ApiModelProperty("收藏时间")
    private LocalDateTime createTime;

    @ApiModelProperty("博客作者id(userId)")
    private String blogAuthId;

    @ApiModelProperty("博客作者名称")
    private String blogAuthName;

}
