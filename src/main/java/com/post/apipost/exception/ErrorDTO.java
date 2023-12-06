package com.post.apipost.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ErrorDTO implements Serializable {
    private static final long serialVersionIUD=1L;

    private String error;
    private String message;
    private int status;
    private LocalDateTime dateTime;
}
