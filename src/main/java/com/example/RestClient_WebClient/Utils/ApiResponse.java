package com.example.RestClient_WebClient.Utils;

public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T data;

    public ApiResponse(){}

    public ApiResponse(boolean _success, String _message, T _data){
        success = _success;
        message = _message;
        data = _data;
    }

    public boolean getSuccess(){
        return success;
    }
    public String getMessage(){
        return message;
    }
    public T getData(){
        return data;
    }
}
