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
 * 点赞表
 * </p>
 *
 * @author MrFugui
 * @since 2021-11-23
 */
@ApiModel(value = "Good对象", description = "点赞表")
@Data
public class Good implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("点赞表id")
      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("动态表id")
    private Integer dynamicId;

    @ApiModelProperty("博客id")
    private Integer blogId;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("创建用户")
    private Integer createUser;



}
