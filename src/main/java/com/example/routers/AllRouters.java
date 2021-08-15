package com.example.routers;

import com.example.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

public class AllRouters {
    @Bean
    public RouterFunction<ServerResponse> userRouter(UserHandler userHandler) {
        return RouterFunctions.nest(
                RequestPredicates.path("/user"),  //绑定请求是那个，相当于Controller类上的@RequestMapping
                RouterFunctions.route(
                        RequestPredicates.GET("/"),   //绑定具体的请求，相当于Controller类中具体某个处理方法的 @RequestMapping 或 @GetMapping等
                        userHandler::getAllUser       //这个就是对应处理的方法
                ).andRoute(RequestPredicates
                                .POST("/")
                                .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                        userHandler::createUser
                )
        );
    }
}
