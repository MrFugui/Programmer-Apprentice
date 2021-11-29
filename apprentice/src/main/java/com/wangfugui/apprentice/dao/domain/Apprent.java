package com.wangfugui.apprentice.dao.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author MrFugui
 * @since 2021-11-29
 */
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
    private LocalDateTime apprentTime;

    @ApiModelProperty("师徒关系状态")
    private Integer apprentStatus;

    @ApiModelProperty("解除关系时间")
    private LocalDateTime dismissTime;

    @ApiModelProperty("出师时间")
    private LocalDateTime finishTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Integer getParentLevel() {
        return parentLevel;
    }

    public void setParentLevel(Integer parentLevel) {
        this.parentLevel = parentLevel;
    }

    public LocalDateTime getApprentTime() {
        return apprentTime;
    }

    public void setApprentTime(LocalDateTime apprentTime) {
        this.apprentTime = apprentTime;
    }

    public Integer getApprentStatus() {
        return apprentStatus;
    }

    public void setApprentStatus(Integer apprentStatus) {
        this.apprentStatus = apprentStatus;
    }

    public LocalDateTime getDismissTime() {
        return dismissTime;
    }

    public void setDismissTime(LocalDateTime dismissTime) {
        this.dismissTime = dismissTime;
    }

    public LocalDateTime getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(LocalDateTime finishTime) {
        this.finishTime = finishTime;
    }

    @Override
    public String toString() {
        return "Apprent{" +
        "id=" + id +
        ", userId=" + userId +
        ", userName=" + userName +
        ", parentId=" + parentId +
        ", parentName=" + parentName +
        ", parentLevel=" + parentLevel +
        ", apprentTime=" + apprentTime +
        ", apprentStatus=" + apprentStatus +
        ", dismissTime=" + dismissTime +
        ", finishTime=" + finishTime +
        "}";
    }
}
