package com.cloud.utc.bean;

public class IdentificationResp {
    @Override
    public String toString() {
        return "IdentificationResp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idcard='" + idcard + '\'' +
                ", idcard_front='" + idcard_front + '\'' +
                ", idcard_reverse='" + idcard_reverse + '\'' +
                ", is_check='" + is_check + '\'' +
                '}';
    }

    /**
     * id : 7
     * name : 齐齐
     * idcard : 123123123123123123
     * idcard_front : http://tg.zhudao.ren/uploads/images/idcard_fronts/201910/10/7_1570679816_NddF0P1Vgj.png
     * idcard_reverse : http://tg.zhudao.ren/uploads/images/idcard_fronts/201910/10/7_1570679816_NddF0P1Vgj.png
     * is_check : Waitting verify
     */

    private int id;
    private String name;
    private String idcard;
    private String idcard_front;
    private String idcard_reverse;
    private String is_check;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getIs_check() {
        return is_check;
    }

    public void setIs_check(String is_check) {
        this.is_check = is_check;
    }
}
