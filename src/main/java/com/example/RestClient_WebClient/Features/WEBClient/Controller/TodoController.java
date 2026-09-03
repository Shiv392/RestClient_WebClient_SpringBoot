package com.example.RestClient_WebClient.Features.WEBClient.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RestClient_WebClient.Features.RESTClient.Dtos.Todos;
import com.example.RestClient_WebClient.Features.WEBClient.Services.TodoService;
import com.example.RestClient_WebClient.Utils.ApiResponse;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/webclient/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService _todoService){
        todoService = _todoService;
    }
    
    @GetMapping("")
    public Mono<ResponseEntity<ApiResponse>> getTodos(){
        return todoService.getTodos()
        .map(todo-> ResponseEntity.status(200)
        .body(new ApiResponse(true, "Fetched Todos", todo))
        );
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<ApiResponse>> getTodosById(@PathVariable int id){
        return todoService.getTodoById(id)
        .map(todo-> ResponseEntity.status(200)
            .body(new ApiResponse(true, "Todo fetched successfully", todo))
        );
    }
}
