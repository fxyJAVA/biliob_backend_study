package com.yxf.biliob_backendf_v2.constant;

/**
 * @Desc TODO
 * @Author fxy
 * @Date 2020/6/25 16:12
 **/
public enum  ResultEnum {
    TEST(0000,"测试用"),
    LOGIN_FAILED(-1,"登录失败,账号或密码错误"),
    LOGIN_SUCCESS(1,"登录成功");
    private int code;
    private String message;
    ResultEnum(int code,String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
