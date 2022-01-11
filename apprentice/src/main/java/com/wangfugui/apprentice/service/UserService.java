package com.wangfugui.apprentice.service;

import com.wangfugui.apprentice.common.util.ResponseUtils;
import com.wangfugui.apprentice.dao.domain.User;
import com.wangfugui.apprentice.dao.dto.UserRegisterDto;

/**
 * @author MaSiyi
 * @version 1.0.0 2021/10/23
 * @since JDK 1.8.0
 */
public interface UserService {
    ResponseUtils listUser();

    User getUserInfoForName(String username);

    ResponseUtils insertUser(UserRegisterDto userInfo);

    ResponseUtils updatePwd(String oldPwd, String newPwd);

    User getIdByUserName(String username);

    String getpwdbyname(String name);

    Long getUidbyname(String name);

    String getnamebyid(long id);

    /** 查询用户信息
     * @Param: []
     * @return: com.wangfugui.apprentice.dao.domain.User
     * @Author: MaSiyi
     * @Date: 2021/11/29
     */
    User getUserInfo();

    /** 根据id查询用户信息
     * @Param: [userId]
     * @return: com.wangfugui.apprentice.dao.domain.User
     * @Author: MaSiyi
     * @Date: 2022/1/11
     */
    User getUserInfoForId(String userId);
}
