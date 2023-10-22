package com.example.bean;

import com.example.CustomInstantSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.micronaut.core.annotation.Introspected;
//import io.micronaut.serde.annotation.Serdeable;

import java.time.Instant;
//@Serdeable // (1)
@Introspected
public class JwtResult {
    private String jwtToken;
    @JsonSerialize(using = CustomInstantSerializer.class)
    private Instant ExpireIn;

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public Instant getExpireIn() {
        return ExpireIn;
    }

    public void setExpireIn(Instant expireIn) {
        ExpireIn = expireIn;
    }

    @Override
    public String toString() {
        return "JwtResult{" +
                "jwtToken='" + jwtToken + '\'' +
                ", ExpireIn='" + ExpireIn + '\'' +
                '}';
    }
}
