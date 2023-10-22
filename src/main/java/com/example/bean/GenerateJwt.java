package com.example.bean;

//import io.micronaut.serde.annotation.Serdeable;

public class GenerateJwt {
//    private String iss;
    private String realId;




    public String getRealId() {
        return realId;
    }

    public void setRealId(String realid) {
        this.realId = realid;
    }

    @Override
    public String toString() {
        return "GenerateJwt{" +
                ", realid='" + realId + '\'' +
                '}';
    }
}
