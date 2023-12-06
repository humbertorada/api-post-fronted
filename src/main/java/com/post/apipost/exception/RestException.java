package com.post.apipost.exception;

public class RestException extends Exception{
    private static final long serialVersionIUD=1L;

    private ErrorDTO errorDTO;

    public RestException(){
        super();
    }

    public RestException(ErrorDTO errorDTO){
        super(errorDTO.getError());
        this.errorDTO = errorDTO;
    }

    public RestException(String msg){
        super(msg);
    }

    public RestException(String msg, Exception ex){
        super(msg,ex);
    }

    public ErrorDTO getErrorDTO() {
        return errorDTO;
    }

    public void setErrorDTO(ErrorDTO errorDTO) {
        this.errorDTO = errorDTO;
    }

}
