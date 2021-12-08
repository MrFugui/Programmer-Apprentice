package com.wangfugui.apprentice.dao.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 关注表
 * </p>
 *
 * @author MrFugui
 * @since 2021-12-08
 */
@ApiModel(value = "Follow对象", description = "关注表")
public class Follow implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("关注人")
    private String createUser;

    @ApiModelProperty("关注人名称")
    private String createUserName;

    @ApiModelProperty("被关注人")
    private String followUser;

    @ApiModelProperty("被关注人名称")
    private String followUserName;

    @ApiModelProperty("关注时间")
    private LocalDateTime followTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getFollowUser() {
        return followUser;
    }

    public void setFollowUser(String followUser) {
        this.followUser = followUser;
    }

    public String getFollowUserName() {
        return followUserName;
    }

    public void setFollowUserName(String followUserName) {
        this.followUserName = followUserName;
    }

    public LocalDateTime getFollowTime() {
        return followTime;
    }

    public void setFollowTime(LocalDateTime followTime) {
        this.followTime = followTime;
    }

    @Override
    public String toString() {
        return "Follow{" +
        "id=" + id +
        ", createUser=" + createUser +
        ", createUserName=" + createUserName +
        ", followUser=" + followUser +
        ", followUserName=" + followUserName +
        ", followTime=" + followTime +
        "}";
    }
}
