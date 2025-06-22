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
}
