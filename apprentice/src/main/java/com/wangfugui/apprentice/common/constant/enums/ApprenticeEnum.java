package com.wangfugui.apprentice.common.constant.enums;

/**
 * 拜师收徒类型枚举
 *
 * @author MaSiyi
 * @version 1.0.0 2021/12/9
 * @since JDK 1.8.0
 */
public enum ApprenticeEnum {
    Master(1, "拜师"), Apprentice(0, "收徒"),
    APPLYING(0, "申请中"), HASAPPRENTICE(1, "已拜师"), CLOSEAPPRENTICE(2, "已解除"),
    REFUSE(3,"已拒绝");


    public Integer getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    private Integer type;
    private String value;

    ApprenticeEnum(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
