package com.example.RestClient_WebClient.Features.RESTClient.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.RestClient_WebClient.Features.RESTClient.Dtos.AddPostRequestBody;
import com.example.RestClient_WebClient.Features.RESTClient.Dtos.Post;
import com.example.RestClient_WebClient.Features.RESTClient.Services.PostService;
import com.example.RestClient_WebClient.Utils.ApiResponse;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/restclient/posts")
public class RestClientPostController {

    private final PostService postService;

    public RestClientPostController(PostService _postService){
        postService = _postService;
    }
    
    @GetMapping("")
    public ResponseEntity<ApiResponse> getPosts() {
        List<Post>postList = postService.getPosts();
        return ResponseEntity.status(200)
        .body(
            new ApiResponse(true, "Fetched all posts", postList)
        );
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getMethodName(@PathVariable int id) {
        Post post = postService.getPostById(id);
        return ResponseEntity.status(200)
        .body(
            new ApiResponse(true, "Fetched all posts", post)
        );
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse> addPosts(@RequestBody AddPostRequestBody requestBody) {
        Post post = postService.addPost(requestBody);
        return ResponseEntity.status(200)
        .body(
            new ApiResponse(true, "Fetched all posts", post)
        );
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> putPost(@PathVariable int id, @RequestBody Post requestBody) {
        Post post = postService.updatePost(requestBody, id);
        return ResponseEntity.status(200)
        .body(
            new ApiResponse(true, "Fetched all posts", post)
        );
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse> patchPost(@PathVariable int id, @RequestBody Post requestBody) {
        Post post = postService.patchPost(requestBody, id);
        return ResponseEntity.status(200)
        .body(
            new ApiResponse(true, "Fetched all posts", post)
        );
    }
}
