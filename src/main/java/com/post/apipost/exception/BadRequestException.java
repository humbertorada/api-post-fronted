package com.post.apipost.exception;

public class BadRequestException extends  RestException{
    private static final long serialVersionIUD=1L;

    public BadRequestException(){
        super();
    }

    public BadRequestException(ErrorDTO errorDTO){
        super(errorDTO);
    }

    public BadRequestException(String msg){
        super(msg);
    }

}
