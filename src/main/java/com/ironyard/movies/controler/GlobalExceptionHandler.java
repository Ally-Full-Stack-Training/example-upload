package com.ironyard.movies.controler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;


//@ControllerAdvice
//@RestController
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = Throwable.class)
    public String handleBaseException(Throwable e){
        return e.getMessage();
    }

    @ExceptionHandler(value = SQLException.class)
    public String handleSQLException(Exception e){return e.getMessage();}


}
