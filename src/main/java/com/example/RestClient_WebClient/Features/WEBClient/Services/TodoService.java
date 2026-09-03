package com.example.RestClient_WebClient.Features.WEBClient.Services;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.RestClient_WebClient.Features.RESTClient.Dtos.Todos;

import reactor.core.publisher.Mono;

@Service
public class TodoService {
    private final WebClient webClient;

    public TodoService(WebClient _webClient){
        webClient = _webClient;
    }

    //Here Mono like Promise that is it will be available in the future.
    //this allows async programming without blocking the main thread. 
    //Here mono is not the actuall value of async method. it emits when after operation.
    //Mono<Todos> here Mono will emit Todos object 

    //get all the todo list
    public Mono<List<Todos>> getTodos(){
        return webClient.get()
        .uri("/todos")
        .retrieve()
        .bodyToMono(new ParameterizedTypeReference<List<Todos>>(){});
    }

    //get specific id 
    public Mono<Todos> getTodoById(int id){
        return webClient.get()
        .uri("/todos/{id}", id)
        .retrieve()
        .bodyToMono(Todos.class);
    }
}
