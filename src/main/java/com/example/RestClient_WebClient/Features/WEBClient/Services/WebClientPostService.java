package com.example.RestClient_WebClient.Features.WEBClient.Services;

import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.example.RestClient_WebClient.Features.RESTClient.Dtos.AddPostRequestBody;
import com.example.RestClient_WebClient.Features.RESTClient.Dtos.Post;
import reactor.core.publisher.Mono;

@Service
public class WebClientPostService {

    private final WebClient webClient;
    public WebClientPostService(WebClient _webClient){
        webClient = _webClient;
    }

    //get all posts 
    public Mono<List<Post>> getAllPosts(){
        return webClient.get()
        .uri("/posts")
        .header("Content-Type", "application/json")
        .retrieve()
        .bodyToMono(new ParameterizedTypeReference<List<Post>>(){});
    }

    //get post by id
    public Mono<Post> getPostById(int id){
        return webClient.get()
        .uri("/posts/{id}", id)
        .header("Content-Type", "application/json")
        .retrieve()
        .bodyToMono(Post.class);
    }

    //add new Posts
    public Mono<Post> addPost(AddPostRequestBody requestBody){
        return webClient.post()
        .uri("/posts")
        .header("Content-Type", "application/json")
        .bodyValue(requestBody)
        .retrieve()
        .bodyToMono(Post.class);
    }

    //update Posts
    public Mono<Post> putPost(Post requestBody, int id){
        return webClient.put()
        .uri("/posts/{id}", id)
        .header("Content-Type", "application/json")
        .bodyValue(requestBody)
        .retrieve()
        .bodyToMono(Post.class);
    }

    public Mono<Post> patchPost(Post requestBody, int id){
        return webClient.patch()
        .uri("/posts/{id}", id)
        .header("Content-Type", "application/json")
        .bodyValue(requestBody)
        .retrieve()
        .bodyToMono(Post.class);
    }

    public Mono<Boolean> deletePost(int id){
        return webClient.delete()
        .uri(uriBuilder-> uriBuilder
            .path("/posts")
            .queryParam("id", id)
            .build()
        )
        .header("Content-Type", "application/json")
        .retrieve()
        .bodyToMono(Post.class)
        .map(post-> true);
    }

    //return only if id is even
    public Mono<Post> evenIdPost(int id){
        return webClient.get()
        .uri("/posts/{id}", id)
        .retrieve()
        .bodyToMono(Post.class)
        .filter(post-> post.getId()%2==0);
    }
}
