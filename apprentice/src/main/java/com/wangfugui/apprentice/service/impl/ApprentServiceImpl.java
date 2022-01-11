package com.wangfugui.apprentice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangfugui.apprentice.common.constant.NotifyConstant;
import com.wangfugui.apprentice.common.constant.enums.ApprenticeEnum;
import com.wangfugui.apprentice.common.util.ResponseUtils;
import com.wangfugui.apprentice.dao.domain.Apprent;
import com.wangfugui.apprentice.dao.domain.User;
import com.wangfugui.apprentice.dao.dto.SendAskDto;
import com.wangfugui.apprentice.dao.mapper.ApprentMapper;
import com.wangfugui.apprentice.service.IApprentService;
import com.wangfugui.apprentice.service.INotifyService;
import com.wangfugui.apprentice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author MrFugui
 * @since 2021-11-29
 */
@Service
public class ApprentServiceImpl extends ServiceImpl<ApprentMapper, Apprent> implements IApprentService {

    @Autowired
    private ApprentMapper apprentMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private INotifyService notifyService;


    /**
     * 师傅列表
     *
     * @Param: [userId]
     * @return: com.wangfugui.apprentice.common.util.ResponseUtils
     * @Author: MaSiyi
     * @Date: 2021/11/30
     */
    @Override
    public ResponseUtils listMaster() {
        User userInfo = userService.getUserInfo();
        QueryWrapper<Apprent> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.lambda().eq(Apprent::getUserId, userInfo.getId());
        return ResponseUtils.success(apprentMapper.selectList(userQueryWrapper));
    }

    /**
     * 徒弟列表
     *
     * @Param: [userId]
     * @return: com.wangfugui.apprentice.common.util.ResponseUtils
     * @Author: MaSiyi
     * @Date: 2021/11/30
     */
    @Override
    public ResponseUtils listApprentice() {
        User userInfo = userService.getUserInfo();
        QueryWrapper<Apprent> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.lambda().eq(Apprent::getParentId, userInfo.getId());

        return ResponseUtils.success(apprentMapper.selectList(userQueryWrapper));
    }

    /**
     * 发送拜师收徒请求
     *
     * @param sendAskDto
     * @Param: [sendAskDto]
     * @return: com.wangfugui.apprentice.common.util.ResponseUtils
     * @Author: MaSiyi
     * @Date: 2021/12/9
     */
    @Override
    public ResponseUtils sendMasterApprenticeAsk(SendAskDto sendAskDto) {
        int askType = sendAskDto.getAskType();
        boolean aBoolean = false;
        //拜师
        if (ApprenticeEnum.Master.getType().equals(askType)) {
            aBoolean = notifyService.addMasterApprenticeNotify(sendAskDto.getToUserId(), NotifyConstant.NotifyType.MASTER);
        } else if (ApprenticeEnum.Apprentice.getType().equals(askType)) {
            aBoolean = notifyService.addMasterApprenticeNotify(sendAskDto.getToUserId(), NotifyConstant.NotifyType.APPRENTICE);
        }

        //添加师徒关系表
        Apprent apprent = new Apprent();
        User userInfo = userService.getUserInfo();
        apprent.setUserId(userInfo.getId());
        apprent.setUserName(userInfo.getUsername());
        apprent.setParentId(sendAskDto.getToUserId());
        apprent.setParentName(sendAskDto.getToUserName());
        apprent.setApprentStatus(ApprenticeEnum.APPLYING.getType());
        apprent.setApprentTime(new Date());

        this.save(apprent);

        return ResponseUtils.success(aBoolean);
    }

    /**
     * 请求列表
     *
     * @Param: []
     * @return: com.wangfugui.apprentice.common.util.ResponseUtils
     * @Author: MaSiyi
     * @Date: 2021/12/11
     */
    @Override
    public ResponseUtils askList() {
        User userInfo = userService.getUserInfo();
        QueryWrapper<Apprent> apprentQueryWrapper = new QueryWrapper<>();
        Integer userId = userInfo.getId();
        LambdaQueryWrapper<Apprent> eq = apprentQueryWrapper.lambda().eq(Apprent::getParentId, userId).or().eq(Apprent::getUserId, userId);
        return ResponseUtils.success(apprentMapper.selectList(eq));
    }

    @Override
    public ResponseUtils agree(Apprent apprent) {
        return ResponseUtils.success(updateById(apprent));
    }
}
