package com.wangfugui.apprentice.common.util;

import com.wangfugui.apprentice.common.constant.CodeEnums;
import lombok.Data;
import org.springframework.util.StringUtils;

@Data
public class ResultUtils {
    private String code;
    private String msg;
    private Object data;


    public ResultUtils() {

    }

    public ResultUtils(Object data, CodeEnums codeEnums) {
        this.data = data;
        this.code = codeEnums.getCode();
        this.msg = codeEnums.getMsg();
    }

    public ResultUtils(Object data, String code, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }


    public static ResultUtils success() {
        return new ResultUtils((Object)null, CodeEnums.SUCCESS_CODE);
    }

    public static ResultUtils success(Object data) {
        return new ResultUtils(data, CodeEnums.SUCCESS_CODE);
    }



    public static ResultUtils error() {
        return new ResultUtils((Object)null, CodeEnums.ERROR_CODE);
    }

    public static ResultUtils error(Object data) {
        return new ResultUtils(data, CodeEnums.ERROR_CODE);
    }


    public static ResultUtils msg(String msg) {
        return new ResultUtils((Object)null, CodeEnums.ERROR_MSG.getCode(), msg);
    }

    public static ResultUtils notLogin() {
        return new ResultUtils((Object)null, CodeEnums.NOT_LOGIN);
    }

    public static ResultUtils noResult() {
        return new ResultUtils((Object)null, CodeEnums.NO_RESULT);
    }

    public static ResultUtils build(Object data, String code, String msg) {
        return new ResultUtils(data, code, msg);
    }

    public static ResultUtils build(Object data, CodeEnums codeEnums) {
        return new ResultUtils(data, codeEnums.getCode(), codeEnums.getMsg());
    }

    public static ResultUtils build(CodeEnums codeEnums) {
        return new ResultUtils(null, codeEnums.getCode(), codeEnums.getMsg());
    }

    public static ResultUtils build(String code, String msg) {
        return new ResultUtils(null, code, msg);
    }

}
