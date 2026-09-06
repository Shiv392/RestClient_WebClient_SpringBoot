package com.example.RestClient_WebClient.Features.RESTClient.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.RestClient_WebClient.Features.RESTClient.Services.TodoService;
import com.example.RestClient_WebClient.Utils.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import com.example.RestClient_WebClient.Features.RESTClient.Dtos.Todos;


@RestController
@RequestMapping("/restclient/todo")
public class RestClientTodoController {

    private final TodoService todoService;

    public RestClientTodoController(TodoService _TodoService){
        todoService = _TodoService;
    }
    
    //get todo items list. 
    @GetMapping("")
    public ResponseEntity<ApiResponse> getTodos() {
        List<Todos>todoUsers = todoService.getTodos();
        return ResponseEntity.status(200)
        .body(
            new ApiResponse(true, "Todo List fetched successfully", todoUsers)
        );
    }
    
    //get todo item by id. 
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getMethodName(@PathVariable int id) {
        Todos todos = todoService.getTodoById(id);
        return ResponseEntity.status(200)
        .body(
            new ApiResponse(true, "Todos data", todos)
        );
    }
    
}
