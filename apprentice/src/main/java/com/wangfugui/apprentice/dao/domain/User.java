package com.wangfugui.apprentice.dao.domain;

import lombok.Data;

@Data
public class User {
    private String id;
    private String email;
    private String userName;
    private String password;
    private String photo;
    private String status;
    private String registerDate;
    private String contactNo;
    private String delFlag;
    private String createTime;
    private String updateTime;
    private String nickname;
}