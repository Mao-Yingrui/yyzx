package com.neutech.vo;

public class ResultJson {
    private Integer code;
    private Object content;
    private String message;

    public Integer getCode() {
        return code;
    }

    public Object getContent() {
        return content;
    }

    public String getMessage() {
        return message;
    }

    public ResultJson(Integer code, Object content, String message) {
        this.code = code;
        this.content = content;
        this.message = message;
    }

    /**
     * 成功响应
     * @param content 返回数据
     * @return ResultJson实例
     */
    public static ResultJson success(Object content) {
        return new ResultJson(200, content, "成功");
    }

    /**
     * 失败响应
     * @param message 错误信息
     * @return ResultJson实例
     */
    public static ResultJson fail(String message) {
        return new ResultJson(500, null, message);
    }

    /**
     * 失败响应
     * @param code 错误代码
     * @param message 错误信息
     * @return ResultJson实例
     */
    public static ResultJson fail(Integer code, String message) {
        return new ResultJson(code, null, message);
    }
}
