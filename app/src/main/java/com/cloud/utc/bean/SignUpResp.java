package com.cloud.utc.bean;

public class SignUpResp {

    /**
     * id : 6
     * name : TG_Cwgz7O
     * is_online : false
     * icode : UL0Vbd
     * icode_qrcode : data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAGQAAABkCAIAAAD/gAIDAAACoUlEQVR4nO2bwW7EIAxEu6v+/yevekgPSK6teWBI2513ihIgaDIyxMDj9Xp9GI3n3R34S1gsgMUCWCyAxQJYLIDFAlgsgMUCWCyAxQJYLIDFAlgsgMUCWCyAxQJYLIDFAlgswOdi/edTlftaGbnKZ9djSaX9WFfpwzR2FmDVWRf1F4uuGe8o3hlLZu/S+zCNnQXocdZF/Hrxa9dlrqeZg2Kkm+vDNHYWoNNZK0RHbPXIHHYW4B5nZTMpJcbdyC/qyu+n01lKTKk9Fe9k5esRcxN2FqDHWXpkiY6o/xPr8nN9mMbOAjxunLxkGYjx6Ygyg9+KnQVYdVYWKbJsQRabYl3actafRj/aWYBd+azxS9bfVsl2jmWyluv+tGBnAfr/DZWopGRK6Vy/jl8tXrOzAHszpRf66Ja1pvhUWSXyaHiOnhm8kpOqRy5lNq/PmNqj1XezXQ29AyfyWbUjlBFTj1mxJ40us7MAu/Y66LEpexqJ83i9Py3YWYBd/4b1mFi3U0e3ej41914ROwuw6qw6+mQls5UbJXtRszWPamcB+udZczNsZQQc78RrJWu6iJ0F6JlnKWt5esSJ17EFJQLq7xWxswA9o2G8Mzc+1u0oMUjJ005jZwE681mKp2gGYt0jjln3cHqvw8oa39xu6Ll3/dyBlcrvxumzO/T/Tll/Xtk3j7CzAKfP7tCn9RpP9vY6wzWNnQU4fXYnQ8mLrqwMtWBnAU6fsFCyFEoGVd9HWLfDOr9S+d245+yOvpshrhJmUax9z8wP3e5t7n9z+uxOXVKfScVaWUnP4O/h9NmdrNbcmra+Lt2CnQW48+zOn8POAlgsgMUCWCyAxQJYLIDFAlgsgMUCWCyAxQJYLIDFAlgsgMUCWCyAxQJYLIDFAlgswBcQZiiSBj89HAAAAABJRU5ErkJggg==
     * node_address : 0x204a096d417a51e2a508e94c49b36eedbf53aebd
     * tg : 0.00000000
     * cold_tg : 0.00000000
     * online_at :
     * offline_at :
     * status : true
     * hashrate : 233
     * team_hashrate : 222
     * meta : {"access_token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC90Zy56aHVkYW8ucmVuXC9hcGlcL3VzZXJzIiwiaWF0IjoxNTcwNjI4MDg3LCJleHAiOjE1NzA2MzE2ODcsIm5iZiI6MTU3MDYyODA4NywianRpIjoiRk03NFhJRThvTnVBa3k1WiIsInN1YiI6NiwicHJ2IjoiMjNiZDVjODk0OWY2MDBhZGIzOWU3MDFjNDAwODcyZGI3YTU5NzZmNyJ9.BekRqnHxAUtc5CA08zmFezt6qaShPad6lmZ94jd3eY0","token_type":"Bearer","expires_in":3600}
     */

    private int id;
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
    private MetaBean meta;

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

    public MetaBean getMeta() {
        return meta;
    }

    public void setMeta(MetaBean meta) {
        this.meta = meta;
    }

    public static class MetaBean {
        /**
         * access_token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC90Zy56aHVkYW8ucmVuXC9hcGlcL3VzZXJzIiwiaWF0IjoxNTcwNjI4MDg3LCJleHAiOjE1NzA2MzE2ODcsIm5iZiI6MTU3MDYyODA4NywianRpIjoiRk03NFhJRThvTnVBa3k1WiIsInN1YiI6NiwicHJ2IjoiMjNiZDVjODk0OWY2MDBhZGIzOWU3MDFjNDAwODcyZGI3YTU5NzZmNyJ9.BekRqnHxAUtc5CA08zmFezt6qaShPad6lmZ94jd3eY0
         * token_type : Bearer
         * expires_in : 3600
         */

        private String access_token;
        private String token_type;
        private int expires_in;

        public String getAccess_token() {
            return access_token;
        }

        public void setAccess_token(String access_token) {
            this.access_token = access_token;
        }

        public String getToken_type() {
            return token_type;
        }

        public void setToken_type(String token_type) {
            this.token_type = token_type;
        }

        public int getExpires_in() {
            return expires_in;
        }

        public void setExpires_in(int expires_in) {
            this.expires_in = expires_in;
        }
    }
}
