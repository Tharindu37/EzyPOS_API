package com.bootcamp.pos.EzyPOS.adviser;

import com.bootcamp.pos.EzyPOS.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(ClassNotFoundException.class)
    public ResponseEntity<StandardResponse> handleNotFoundExceptions(ClassNotFoundException e){
        return new ResponseEntity<>(
                new StandardResponse(
                        404,
                        e.getMessage()+" was occurred!",
                        e
                ), HttpStatus.NOT_FOUND
        );
    }
}
