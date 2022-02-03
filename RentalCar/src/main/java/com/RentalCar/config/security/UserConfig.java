package com.RentalCar.config.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("gestuser")
public class UserConfig
{
    private String srvUrl;
    private String username;
    private String password;

    public String getSrvUrl() {
        return srvUrl;
    }

    public void setSrvUrl(String srvUrl) {
        this.srvUrl = srvUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userId) {
        this.username = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}