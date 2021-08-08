package com.example.demo;

import reactor.core.publisher.Flux;

public class Demo {
    public static void main(String[] args) {
        // Flux 其实就是
        Flux.fromArray(new String[]{"hello", "word"})
                .map(s -> s.length()) //中间操作
                .subscribe(x -> {     //终止操作
                    System.out.println(x);
                });
    }
}
