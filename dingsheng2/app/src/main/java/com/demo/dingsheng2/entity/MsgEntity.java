package com.demo.dingsheng2.entity;

/**
 * created by tea9 at 2018/12/19
 */
public class MsgEntity {

    /**
     * code : 400
     * data : null
     * msg : 激活失败
     */

    private int code;
    private Object data;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
