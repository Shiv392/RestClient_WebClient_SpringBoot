package com.example.RestClient_WebClient.Features.WEBClient.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.RestClient_WebClient.Features.WEBClient.Services.WebClientPostService;
import com.example.RestClient_WebClient.Utils.ApiResponse;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final WebClientPostService webClientPostService;

    public PostController(WebClientPostService _webClientPostService){
        webClientPostService = _webClientPostService;
    }

    @GetMapping("")
    public Mono<ResponseEntity<ApiResponse>> getAllPosts(){
        return webClientPostService.getAllPosts()
            .map(post-> ResponseEntity.status(200)
            .body(new ApiResponse(true, "Successfully fetched", post))
        );
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<ApiResponse>> getPostById(@PathVariable int id){
        return webClientPostService.getPostById(id)
        .map(post-> ResponseEntity.status(200)
            .body(new ApiResponse(true, "Succcessfully fetched", post)
        ));
    }

    
}
