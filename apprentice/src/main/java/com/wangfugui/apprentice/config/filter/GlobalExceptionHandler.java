package com.wangfugui.apprentice.config.filter;



import com.wangfugui.apprentice.common.exception.ApprenticeException;
import com.wangfugui.apprentice.common.util.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理类
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    /** 处理的所有的 Exception
     * @Param:
     * @return:
     * @Author: MaSiyi
     * @Date: 2021/12/6
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseUtils error(Exception e){
        e.printStackTrace();
        return ResponseUtils.error();
    }

    /** 处理自己写的统一异常 CodingException
     * @Param:
     * @return:
     * @Author: MaSiyi
     * @Date: 2021/12/6
     */
    @ExceptionHandler(ApprenticeException.class)
    @ResponseBody
    public ResponseUtils error(ApprenticeException e){
        log.error(e.getMsg(),e);
        return ResponseUtils.msg(e.getMsg());
    }

}
