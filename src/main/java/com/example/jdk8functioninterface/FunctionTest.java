package com.example.jdk8functioninterface;

import java.util.function.Function;

public class FunctionTest {
    public static void main(String[] args) {

        Function<String, String> function = (input) -> {
            return "bcd";
        };

        System.out.println(function.apply("my input"));

        test(input -> "abc");

    }

    public static void test(Function<String, String> function) {
        System.out.println(function.apply("my Input"));
    }
}
