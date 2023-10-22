package com.example;


import com.example.bean.GenerateJwt;
import com.example.bean.JwtResult;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




@Singleton
public class JwtService {
    @Inject
    CreateJwtToken createJwtToken;
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtService.class);

    public JwtResult generateJWT(GenerateJwt generateJwt) {
        try {
            LOGGER.info("Generate JWT for this customer {}",generateJwt.getRealId());
            return createJwtToken.createJWT(generateJwt);
        } catch (Exception e) {
            LOGGER.info("Error in Service " + e);
            throw e;
        }
    }
}
