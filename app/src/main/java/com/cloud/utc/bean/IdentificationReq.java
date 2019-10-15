package com.cloud.utc.bean;

public class IdentificationReq {

    public IdentificationReq(String name, String idcard, String idcard_front, String idcard_reverse) {
        this.idcard = idcard;
        this.idcard_front = idcard_front;
        this.idcard_reverse = idcard_reverse;
        this.name = name;
    }

    /**
     * idcard : 123123123123123123
     * idcard_front : http://tg.zhudao.ren/uploads/images/idcard_fronts/201910/10/7_1570679816_NddF0P1Vgj.png
     * idcard_reverse : http://tg.zhudao.ren/uploads/images/idcard_reverses/201910/10/7_1570679878_LX8NVYcuWU.png
     * name : 齐齐
     */

    private String idcard;
    private String idcard_front;
    private String idcard_reverse;
    private String name;

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getIdcard_front() {
        return idcard_front;
    }

    public void setIdcard_front(String idcard_front) {
        this.idcard_front = idcard_front;
    }

    public String getIdcard_reverse() {
        return idcard_reverse;
    }

    public void setIdcard_reverse(String idcard_reverse) {
        this.idcard_reverse = idcard_reverse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
