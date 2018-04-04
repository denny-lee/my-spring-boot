package com.lee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : Liw
 * @description :
 * @date : 2018/2/9 14:51
 */
@ControllerAdvice(annotations = Controller.class)
public class AnyController {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Object handleIOException(MethodArgumentNotValidException ex) {
        // prepare responseEntity
        System.out.println("-------------------catch" +  ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
//		return "{\"result\":\"" + ex.getBindingResult().getAllErrors().get(0).getDefaultMessage() + "\"}";
        return ex.getBindingResult().getAllErrors();
    }
}
