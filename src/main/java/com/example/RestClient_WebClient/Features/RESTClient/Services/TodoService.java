package com.example.RestClient_WebClient.Features.RESTClient.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.example.RestClient_WebClient.Features.RESTClient.Dtos.Todos;

@Service
public class TodoService {
    private final RestClient restClient;

    public TodoService(
        RestClient _restClient
    ){
        restClient = _restClient;
    }

    public List<Todos> getTodos(){
        return restClient.get()
        .uri("/todos")
        .retrieve()
        .body(new ParameterizedTypeReference<List<Todos>>() {});

        //here body() will convert API Response into Java Object of given type 
        //then return;
    }

    public Todos getTodoById(int id){
        return restClient.get()
        .uri("/todos/" +id)
        .retrieve()
        .onStatus(
            status-> status.value() == 404,
            (request, response)->{
                throw new RuntimeException("Record not found");
            }
        )
        .body(Todos.class);
    }
}
