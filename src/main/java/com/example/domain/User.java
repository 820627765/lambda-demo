package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;

//@Document(collection = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    //@Id
    private String id;
    private String name;
    private int age;
}
