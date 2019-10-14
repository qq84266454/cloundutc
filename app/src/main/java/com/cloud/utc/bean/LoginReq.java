package com.cloud.utc.bean;

public class LoginReq {
    public LoginReq(String account) {
        this.account = account;
    }

    private String account;
    private String password;
    private String code;// 图片验证码需要用的验证码.


    public LoginReq() {
    }

    public LoginReq(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
