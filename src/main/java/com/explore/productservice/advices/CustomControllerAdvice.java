package com.explore.productservice.advices;

import com.explore.productservice.dtos.ErrorDto;
import com.explore.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class CustomControllerAdvice {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorDto> handleNPEEception(){
        ErrorDto errorDto=new ErrorDto();
        errorDto.setMessage("something went wrong");
        ResponseEntity<ErrorDto> responseEntity=
                new ResponseEntity<>(errorDto, HttpStatusCode.valueOf(501));
        return responseEntity;

    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDto> handlePNEException(){
        ErrorDto errorDto=new ErrorDto();
        errorDto.setMessage("Product not found.please try again");
        ResponseEntity<ErrorDto> responseEntity=
                new ResponseEntity<>(errorDto, HttpStatusCode.valueOf(404));
        return responseEntity;
    }

    @ExceptionHandler(Exception.class)
    public void handleAllExceptions(){

    }

}
