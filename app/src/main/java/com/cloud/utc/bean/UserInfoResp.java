package com.cloud.utc.bean;

public class UserInfoResp {

    @Override
    public String toString() {
        return "UserInfoResp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", is_online=" + is_online +
                ", icode='" + icode + '\'' +
                ", icode_qrcode='" + icode_qrcode + '\'' +
                ", node_address='" + node_address + '\'' +
                ", tg='" + tg + '\'' +
                ", cold_tg='" + cold_tg + '\'' +
                ", online_at='" + online_at + '\'' +
                ", offline_at='" + offline_at + '\'' +
                ", status=" + status +
                ", hashrate=" + hashrate +
                ", team_hashrate=" + team_hashrate +
                '}';
    }

    /**
     * id : 7
     * name : TG_iOhWVc
     * is_online : false
     * icode : SjOTou
     * icode_qrcode : data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAGQAAABkCAIAAAD/gAIDAAACoUlEQVR4nO2bwW7EIAxEu6v+/yevekgPSK6teWBI2513ihIgaDIyxMDj9Xp9GI3n3R34S1gsgMUCWCyAxQJYLIDFAlgsgMUCWCyAxQJYLIDFAlgsgMUCWCyAxQJYLIDFAlgswOdi/edTlftaGbnKZ9djSaX9WFfpwzR2FmDVWRf1F4uuGe8o3hlLZu/S+zCNnQXocdZF/Hrxa9dlrqeZg2Kkm+vDNHYWoNNZK0RHbPXIHHYW4B5nZTMpJcbdyC/qyu+n01lKTKk9Fe9k5esRcxN2FqDHWXpkiY6o/xPr8nN9mMbOAjxunLxkGYjx6Ygyg9+KnQVYdVYWKbJsQRabYl3actafRj/aWYBd+azxS9bfVsl2jmWyluv+tGBnAfr/DZWopGRK6Vy/jl8tXrOzAHszpRf66Ja1pvhUWSXyaHiOnhm8kpOqRy5lNq/PmNqj1XezXQ29AyfyWbUjlBFTj1mxJ40us7MAu/Y66LEpexqJ83i9Py3YWYBd/4b1mFi3U0e3ej41914ROwuw6qw6+mQls5UbJXtRszWPamcB+udZczNsZQQc78RrJWu6iJ0F6JlnKWt5esSJ17EFJQLq7xWxswA9o2G8Mzc+1u0oMUjJ005jZwE681mKp2gGYt0jjln3cHqvw8oa39xu6Ll3/dyBlcrvxumzO/T/Tll/Xtk3j7CzAKfP7tCn9RpP9vY6wzWNnQU4fXYnQ8mLrqwMtWBnAU6fsFCyFEoGVd9HWLfDOr9S+d245+yOvpshrhJmUax9z8wP3e5t7n9z+uxOXVKfScVaWUnP4O/h9NmdrNbcmra+Lt2CnQW48+zOn8POAlgsgMUCWCyAxQJYLIDFAlgsgMUCWCyAxQJYLIDFAlgsgMUCWCyAxQJYLIDFAlgswBcQZiiSBj89HAAAAABJRU5ErkJggg==
     * node_address : 0x204a096d417a51e2a508e94c49b36eedbf53aebd
     * tg : 0.00000000
     * cold_tg : 0.00000000
     * online_at :
     * offline_at :
     * status : true
     * hashrate : 233
     * team_hashrate : 222
     */

    private String id;
    private String name;
    private boolean is_online;
    private String icode;
    private String icode_qrcode;
    private String node_address;
    private String tg;
    private String cold_tg;
    private String online_at;
    private String offline_at;
    private boolean status;
    private int hashrate;
    private int team_hashrate;

    public String getId() {
        return id;
    }

    public void setId(String  id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIs_online() {
        return is_online;
    }

    public void setIs_online(boolean is_online) {
        this.is_online = is_online;
    }

    public String getIcode() {
        return icode;
    }

    public void setIcode(String icode) {
        this.icode = icode;
    }

    public String getIcode_qrcode() {
        return icode_qrcode;
    }

    public void setIcode_qrcode(String icode_qrcode) {
        this.icode_qrcode = icode_qrcode;
    }

    public String getNode_address() {
        return node_address;
    }

    public void setNode_address(String node_address) {
        this.node_address = node_address;
    }

    public String getTg() {
        return tg;
    }

    public void setTg(String tg) {
        this.tg = tg;
    }

    public String getCold_tg() {
        return cold_tg;
    }

    public void setCold_tg(String cold_tg) {
        this.cold_tg = cold_tg;
    }

    public String getOnline_at() {
        return online_at;
    }

    public void setOnline_at(String online_at) {
        this.online_at = online_at;
    }

    public String getOffline_at() {
        return offline_at;
    }

    public void setOffline_at(String offline_at) {
        this.offline_at = offline_at;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getHashrate() {
        return hashrate;
    }

    public void setHashrate(int hashrate) {
        this.hashrate = hashrate;
    }

    public int getTeam_hashrate() {
        return team_hashrate;
    }

    public void setTeam_hashrate(int team_hashrate) {
        this.team_hashrate = team_hashrate;
    }
}
