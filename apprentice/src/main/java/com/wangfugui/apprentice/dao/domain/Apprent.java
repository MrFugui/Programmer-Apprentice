package com.wangfugui.apprentice.dao.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author MrFugui
 * @since 2021-11-29
 */
@Data
@ApiModel(value = "Apprent对象", description = "")
public class Apprent implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("用户id")
    private Integer userId;

    @ApiModelProperty("用户名称")
    private String userName;

    @ApiModelProperty("师父用户id")
    private Integer parentId;

    @ApiModelProperty("师父名称")
    private String parentName;

    @ApiModelProperty("师父等级")
    private Integer parentLevel;

    @ApiModelProperty("拜师时间")
    private Date apprentTime;

    @ApiModelProperty("师徒关系状态")
    private Integer apprentStatus;

    @ApiModelProperty("解除关系时间")
    private Date dismissTime;

    @ApiModelProperty("出师时间")
    private Date finishTime;



}
