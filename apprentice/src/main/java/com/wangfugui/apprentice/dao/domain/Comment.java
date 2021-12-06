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
 * 评论表
 * </p>
 *
 * @author MrFugui
 * @since 2021-11-23
 */
@Data
@ApiModel(value = "Comment对象", description = "评论表")
public class Comment extends Text implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("评论内容")
    private String commentText;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("创建人")
    private Integer createUser;

    @ApiModelProperty("点赞数量")
    private Integer goodNumber;

    @ApiModelProperty("是否删除")
    private Integer deleteFlag;

    @ApiModelProperty("评论数量")
    private Integer talkNumber;

    @ApiModelProperty("评论表父id")
    private Integer commentId;


}
