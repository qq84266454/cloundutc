package com.cloud.utc.bean;

public class SignUpReq {
    private String account;//	是	string	账户
    private String password;//	是	string	密码
    private String password_confirmation; //是	string	重复密码
    private String icode;//	是	string	邀请码

    @Override
    public String toString() {
        return "SignUpReq{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", password_confirmation='" + password_confirmation + '\'' +
                ", icode='" + icode + '\'' +
                '}';
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

    public String getPassword_confirmation() {
        return password_confirmation;
    }

    public void setPassword_confirmation(String password_confirmation) {
        this.password_confirmation = password_confirmation;
    }

    public String getIcode() {
        return icode;
    }

    public void setIcode(String icode) {
        this.icode = icode;
    }
}
