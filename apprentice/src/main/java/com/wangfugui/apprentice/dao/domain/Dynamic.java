package com.wangfugui.apprentice.dao.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 动态表
 * </p>
 *
 * @author MrFugui
 * @since 2021-11-23
 */
@ApiModel(value = "Dynamic对象", description = "动态表")
public class Dynamic implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("表id")
      private Integer id;

    @ApiModelProperty("动态内容")
    private String dynamicText;

    @ApiModelProperty("图片id")
    private Integer fileId;

    @ApiModelProperty("点赞数量")
    private Integer goodNumber;

    @ApiModelProperty("评论数量")
    private Integer talkNumber;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("是否删除")
    private Boolean deleteFlag;

    @ApiModelProperty("创建人")
    private Integer createUser;

    @ApiModelProperty("地址")
    private String address;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDynamicText() {
        return dynamicText;
    }

    public void setDynamicText(String dynamicText) {
        this.dynamicText = dynamicText;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public Integer getGoodNumber() {
        return goodNumber;
    }

    public void setGoodNumber(Integer goodNumber) {
        this.goodNumber = goodNumber;
    }

    public Integer getTalkNumber() {
        return talkNumber;
    }

    public void setTalkNumber(Integer talkNumber) {
        this.talkNumber = talkNumber;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Dynamic{" +
        "id=" + id +
        ", dynamicText=" + dynamicText +
        ", fileId=" + fileId +
        ", goodNumber=" + goodNumber +
        ", talkNumber=" + talkNumber +
        ", createTime=" + createTime +
        ", deleteFlag=" + deleteFlag +
        ", createUser=" + createUser +
        ", address=" + address +
        "}";
    }
}
