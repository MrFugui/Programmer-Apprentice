package com.wangfugui.apprentice.common.constant;

/**
 * @author MaSiyi
 * @version 1.0.0 2021/12/6
 * @since JDK 1.8.0
 */
public interface NotifyConstant {

    /**
     * 通知类型
     */
    enum NotifyType{

        GOOD("good","点赞"),
        COMMENT("comment","评论"),

        FOLLOW("follow","关注"),
        /**
         * 收藏
         */
        COLLECTION ("collection","收藏"),

        /**
         * 系统
         */
        SYSTEM ("system","系统"),
        /**
         * 拜师
         */
        MASTER("master","拜师"),
        /**
         * 收徒
         */
        APPRENTICE("apprentice","收徒");

        String name;
        String value;

        NotifyType(String name, String value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public String getValue() {
            return value;
        }
    }
    /**
     *
     */
    enum NotifyStatus{
        NOREAD(0, "未读"),
        READ(1, "已读");

        Integer name;
        String value;


        NotifyStatus(Integer name, String value) {
            this.name = name;
            this.value = value;
        }

        public Integer getName() {
            return name;
        }

        public String getValue() {
            return value;
        }
    }
}
