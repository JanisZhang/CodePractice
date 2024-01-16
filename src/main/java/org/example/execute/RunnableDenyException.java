package org.example.execute;

public class RunnableDenyException extends RuntimeException{
    public RunnableDenyException(String message){
        super(message);
    }
}
