package com.hotelreservation.userservice.rest.aspect;

import com.hotelreservation.userservice.api.request.BaseRequest;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Slf4j
@Aspect
@Component
@RequiredArgsConstructor

public class GeneralInterceptorAspect {

    private final HttpServletRequest request;


    //TODO Should we use @After instead @Before

   /* @Before(value = "execution(* com.hotelreservation.userservice.rest.controller..*(..)) ")
    public void beforeController (JoinPoint joinPoint){
        Object [] parameters = joinPoint.getArgs();
        for(Object param : parameters){
            if(param instanceof BaseRequest){
                ((BaseRequest) param).setToken(request.getHeader("Authorization"));
            }
        }
    }*/
}
