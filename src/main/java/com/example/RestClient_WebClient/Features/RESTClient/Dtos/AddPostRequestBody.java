package com.example.RestClient_WebClient.Features.RESTClient.Dtos;

public class AddPostRequestBody {
    private String title;
    private String body;
    private int userId;

    public AddPostRequestBody(){}

    public AddPostRequestBody(String _title, String _body, int _userId){
        title = _title;
        body = _body;
        userId = _userId;
    }

    public String getTitle(){
        return title;
    }
    public String getBody(){
        return body;
    }
    public int getUserId(){
        return userId;
    }
}
