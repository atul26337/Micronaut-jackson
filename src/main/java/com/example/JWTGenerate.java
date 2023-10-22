package com.example;


import com.example.bean.GenerateJwt;
import com.example.bean.JwtResult;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Consumes;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import jakarta.inject.Inject;
import org.reactivestreams.Publisher;

import java.security.Principal;

@Controller("/onecard/bff/app/v1/chat/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JWTGenerate {
    @Inject
    JwtService service;

    @Get("/generate")
    @Produces(MediaType.APPLICATION_JSON)
    public Publisher<? extends HttpResponse> generate() {
        return Flowable.fromCallable(() -> {
            GenerateJwt generateJwt=new GenerateJwt();
            generateJwt.setRealId("1");
            JwtResult token= service.generateJWT(generateJwt);

            return HttpResponse.ok(token);
        }).subscribeOn(Schedulers.io());
    }
}
