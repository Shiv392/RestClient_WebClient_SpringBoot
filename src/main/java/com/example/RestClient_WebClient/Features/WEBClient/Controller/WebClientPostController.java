package com.example.RestClient_WebClient.Features.WEBClient.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RestClient_WebClient.Features.RESTClient.Dtos.Post;
import com.example.RestClient_WebClient.Features.WEBClient.Services.WebClientPostService;
import com.example.RestClient_WebClient.Utils.ApiResponse;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/webclient/posts")
public class WebClientPostController {
    private final WebClientPostService webClientPostService;

    public WebClientPostController(WebClientPostService _webClientPostService){
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

    //filter record where id is even
    @GetMapping("/filterbyevenid")
    public Mono<ResponseEntity<ApiResponse>> getFilterEvenIdPosts(){
        return webClientPostService.getAllPosts()
        .map(post-> post.stream().filter(ele-> ele.getId()%2==0).toList())
        .map(post-> ResponseEntity.status(200)
    .body(new ApiResponse(true, "Successfully fetch", post))
    );
    }

    @GetMapping ("/filteronlyevenid")
    public Mono<ResponseEntity<ApiResponse>> getPostOnlyForEvenId(@PathVariable int id){
        Mono<Post>evenIdPost = webClientPostService.evenIdPost(id);
        if(evenIdPost == null){
            throw new RuntimeException("{id} record not found");
        }

        return evenIdPost.map(post-> ResponseEntity.status(200)
            .body(
                new ApiResponse(true, "Fetched record", post)
            )
        );
    }
  
}
