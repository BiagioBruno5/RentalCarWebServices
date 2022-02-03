package com.RentalCar.config.security;

import java.io.Serializable;

public class JwtTokenResponse implements Serializable {

    public JwtTokenResponse(String tok) {
        token = tok;
    }

    private static final long serialVersionUID = 8317676219297719109L;

    private final String token;

    public String getToken() {
        return token;
    }

}

