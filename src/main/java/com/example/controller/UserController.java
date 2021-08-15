package com.example.controller;

import com.example.domain.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class UserController {
    //private final UserRepository repository;

//    public UserController(UserRepository userRepository) {
//        this.repository = userRepository;
//    }

    /**
     * produces 指定是流一样的返回
     *
     * @return
     */
    @GetMapping(value = "/s", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<User> getAll() {
        return Flux.fromArray(new User[]{new User("1", "zs", 20)
                , new User("2", "ls", 20)});
        //return repository.findAll();
    }
}
