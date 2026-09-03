package com.example.RestClient_WebClient.Features.RESTClient.Services;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import com.example.RestClient_WebClient.Features.RESTClient.Dtos.AddPostRequestBody;
import com.example.RestClient_WebClient.Features.RESTClient.Dtos.Post;

@Service
public class PostService {
    private final RestClient restClient;

    public PostService(RestClient _restClient){
        restClient = _restClient;
    }

    public List<Post> getPosts(){
        return restClient.get()
        .uri("/posts")
        .retrieve()
        .onStatus(
            status-> status.value() == 404,
            (request, response)->{
                throw new RuntimeException("Record not found");
            }
        )
        .body(new ParameterizedTypeReference<List<Post>>() {});
    }

    //find post by id
    public Post getPostById(int id){
        return restClient.get()
        .uri("/posts/{id}",id)
        .retrieve()
        .onStatus(
            status-> status.value() == 404,
            (request, response)->{
                throw new RuntimeException("Record not found");
            }
        )
        .body(Post.class);
    }

    //create new post
    public Post addPost(AddPostRequestBody requestBody){
        return restClient.post()
        .uri("/posts")
        .body(requestBody)
        .retrieve()
        .body(Post.class);
    }

    //updating any resource using put 
    public Post updatePost(Post requestBody, int id){
        return restClient.put()
        .uri("/posts/{id}", id)
        .body(requestBody)
        .retrieve()
        .body(Post.class);
    }

    //updat any resource uisng patch 
    public Post patchPost(Post requestBody, int id){
        return restClient.patch()
        .uri("/posts/{id}", id)
        .body(requestBody)
        .retrieve()
        .body(Post.class);
    }

}
