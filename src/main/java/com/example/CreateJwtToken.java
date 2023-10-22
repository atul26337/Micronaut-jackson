package com.example;



import com.example.bean.GenerateJwt;
import com.example.bean.JwtResult;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.util.Date;
@Singleton
public class CreateJwtToken {
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateJwtToken.class);
    public JwtResult createJWT(GenerateJwt generateJwt){
        try{
            JwtResult jwtResult=new JwtResult();
            Date date=new Date();
            date.setSeconds(date.getSeconds() + 11);
            LOGGER.info("JWT  Expire Time  "+11);
            String token = "11111";
            jwtResult.setJwtToken(token);
            Instant instant = Instant.now();

            jwtResult.setExpireIn(instant);
            LOGGER.info("JWT Generate Result {}",jwtResult.toString());
            LOGGER.info("JWT SucessFully for customer  {} ",generateJwt.getRealId());
            return jwtResult;
        }catch (Exception e){
            LOGGER.error("JWT Generate Exception  {}" +e.getMessage());
            throw e;
        }
    }
}
