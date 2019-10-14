package com.cloud.utc.bean;

public class LoginResp {
    /**
     * access_token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC90Zy56aHVkYW8ucmVuXC9hcGlcL2F1dGhvcml6YXRpb25zIiwiaWF0IjoxNTcwNDMwODkwLCJleHAiOjE1NzA0MzQ0OTAsIm5iZiI6MTU3MDQzMDg5MCwianRpIjoiRmI0SG5rZGVHRFJuM29SUiIsInN1YiI6MSwicHJ2IjoiMjNiZDVjODk0OWY2MDBhZGIzOWU3MDFjNDAwODcyZGI3YTU5NzZmNyJ9.bpotLqcHAns0QOm8MdHeVOjewCuhc2gol2W6pbPejfI
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
