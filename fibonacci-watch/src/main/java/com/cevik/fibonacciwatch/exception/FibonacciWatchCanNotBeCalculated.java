package com.cevik.fibonacciwatch.exception;

public class FibonacciWatchCanNotBeCalculated extends RuntimeException{

    public FibonacciWatchCanNotBeCalculated(String message){
        super(message);
    }
}
