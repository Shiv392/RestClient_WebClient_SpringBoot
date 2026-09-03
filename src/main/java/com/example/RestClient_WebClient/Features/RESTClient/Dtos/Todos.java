package com.example.RestClient_WebClient.Features.RESTClient.Dtos;

public class Todos {
    private int userId;
    private int id;
    private String title;
    private boolean completed;

    public Todos(){}

    public Todos(int _userId, int _id, String _title, boolean _completed){
        userId = _userId;
        id = _id;
        title = _title;
        completed = _completed;
    }
}
