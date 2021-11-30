package com.wangfugui.apprentice.dao.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 用户设置表
 * </p>
 *
 * @author MrFugui
 * @since 2021-11-30
 */
@TableName("user_setting")
@ApiModel(value = "UserSetting对象", description = "用户设置表")
public class UserSetting implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("用户信息")
    private Integer userId;

    @ApiModelProperty("设置类型")
    private Integer settingType;

    @ApiModelProperty("设置值")
    private Integer settingValue;

    @ApiModelProperty("系统配置表id-默认值")
    private Integer systemConfigId;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("设置模块")
    private Integer settingGroup;


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

    public Integer getSettingType() {
        return settingType;
    }

    public void setSettingType(Integer settingType) {
        this.settingType = settingType;
    }

    public Integer getSettingValue() {
        return settingValue;
    }

    public void setSettingValue(Integer settingValue) {
        this.settingValue = settingValue;
    }

    public Integer getSystemConfigId() {
        return systemConfigId;
    }

    public void setSystemConfigId(Integer systemConfigId) {
        this.systemConfigId = systemConfigId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getSettingGroup() {
        return settingGroup;
    }

    public void setSettingGroup(Integer settingGroup) {
        this.settingGroup = settingGroup;
    }

    @Override
    public String toString() {
        return "UserSetting{" +
        "id=" + id +
        ", userId=" + userId +
        ", settingType=" + settingType +
        ", settingValue=" + settingValue +
        ", systemConfigId=" + systemConfigId +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", settingGroup=" + settingGroup +
        "}";
    }
}
