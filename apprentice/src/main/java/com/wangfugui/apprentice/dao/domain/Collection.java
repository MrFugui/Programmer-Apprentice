package com.wangfugui.apprentice.dao.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 收藏表
 * </p>
 *
 * @author MrFugui
 * @since 2021-12-08
 */
@ApiModel(value = "Collection对象", description = "收藏表")
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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getBlogAuthId() {
        return blogAuthId;
    }

    public void setBlogAuthId(String blogAuthId) {
        this.blogAuthId = blogAuthId;
    }

    public String getBlogAuthName() {
        return blogAuthName;
    }

    public void setBlogAuthName(String blogAuthName) {
        this.blogAuthName = blogAuthName;
    }

    @Override
    public String toString() {
        return "Collection{" +
        "id=" + id +
        ", blogId=" + blogId +
        ", createUser=" + createUser +
        ", createTime=" + createTime +
        ", blogAuthId=" + blogAuthId +
        ", blogAuthName=" + blogAuthName +
        "}";
    }
}
