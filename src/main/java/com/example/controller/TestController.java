package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class TestController {
    /**
     * 原springMVC的写法
     * @return
     */
    @GetMapping("/1")
    public String get1() {
        return "something";
    }

    /**
     * WebFlux 的写法，返回的是 Mono 或 Flux 对象
     * Mono 表示 0-1个元素
     * Flux 表示 0-N个元素
     * @return
     */
    @GetMapping("/2")
    public Mono<String> get2() {
        return Mono.just("something");
    }
}
