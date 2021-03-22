package com.example.competition.util;

import java.io.Serializable;

/**
 * @author Chen Anran
 * @date 2021/3/21
 */
public class ReturnMsgUtil implements Serializable {
    /**
     * 状态 0：失败 1：成功
     */
    private int state;
    /**
     * 相关信息
     */
    private String message;

    public int getState() {
        return state;
    }

    public void setState(int stateCode) {
        this.state = stateCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ReturnMsgUtil(int state, String message) {
        this.state = state;
        this.message = message;
    }

    @Override
    public String toString() {
        return "ReturnMsgUtil{" +
                "state=" + state +
                ", message='" + message + '\'' +
                '}';
    }
}
