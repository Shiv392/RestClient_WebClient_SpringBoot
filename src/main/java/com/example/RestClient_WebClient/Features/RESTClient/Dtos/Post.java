package com.example.RestClient_WebClient.Features.RESTClient.Dtos;

public class Post {
    private int id;
    private String title;
    private int userId;
    private String body;

    public Post(){}

    public Post(int _id, int _userId, String _title, String _body){
        id = _id;
        userId = _userId;
        title = _title;
        body = _body;
    }

    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public int getUserId(){
        return userId;
    }
    public String getBody(){
        return body;
    }
}
