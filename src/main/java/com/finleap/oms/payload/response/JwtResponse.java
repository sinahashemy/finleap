package com.finleap.oms.payload.response;

import java.util.List;

public class JwtResponse {
    private String token;
    private String id;
    private String email;


    public JwtResponse(String accessToken, String id, String email) {
        this.token = accessToken;
        this.id = id;
        this.email = email;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
