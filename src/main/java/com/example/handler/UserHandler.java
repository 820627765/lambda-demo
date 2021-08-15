package com.example.handler;

import com.example.domain.User;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class UserHandler {
    public Mono<ServerResponse> getAllUser(ServerRequest request) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(Flux.fromArray(new User[]{new User(), new User()}), User.class);
    }

    public Mono<ServerResponse> createUser(ServerRequest request) {
        // 获取请求参数
        Mono<User> user = request.bodyToMono(User.class);
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(user /*this.repository.saveAll(user)*/, User.class);
    }

    public Mono<ServerResponse> deleteByUserId(ServerRequest request) {
        // 获取请求参数
        String id = request.pathVariable("id");
        return this.repository.findById(id)
                .flatMap(user -> this.repository.delete(user).then(ServerResponse.ok().build()))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}
