package com.wangfugui.apprentice.dao.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 通知表
 * </p>
 *
 * @author MrFugui
 * @since 2021-11-30
 */
@ApiModel(value = "Notify对象", description = "通知表")
public class Notify implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("通知类型")
    private Integer type;

    @ApiModelProperty("通知标题")
    private String notifyTitle;

    @ApiModelProperty("通知内容")
    private String notifyValue;

    @ApiModelProperty("用户id")
    private Integer userId;

    @ApiModelProperty("通知时间")
    private LocalDateTime createTime;

    @ApiModelProperty("查看时间")
    private LocalDateTime readTime;

    @ApiModelProperty("通知状态1已读0未读")
    private Integer notifyStatus;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getNotifyTitle() {
        return notifyTitle;
    }

    public void setNotifyTitle(String notifyTitle) {
        this.notifyTitle = notifyTitle;
    }

    public String getNotifyValue() {
        return notifyValue;
    }

    public void setNotifyValue(String notifyValue) {
        this.notifyValue = notifyValue;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getReadTime() {
        return readTime;
    }

    public void setReadTime(LocalDateTime readTime) {
        this.readTime = readTime;
    }

    public Integer getNotifyStatus() {
        return notifyStatus;
    }

    public void setNotifyStatus(Integer notifyStatus) {
        this.notifyStatus = notifyStatus;
    }

    @Override
    public String toString() {
        return "Notify{" +
        "id=" + id +
        ", type=" + type +
        ", notifyTitle=" + notifyTitle +
        ", notifyValue=" + notifyValue +
        ", userId=" + userId +
        ", createTime=" + createTime +
        ", readTime=" + readTime +
        ", notifyStatus=" + notifyStatus +
        "}";
    }
}
