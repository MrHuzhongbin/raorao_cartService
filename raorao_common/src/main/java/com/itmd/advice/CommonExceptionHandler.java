package com.itmd.advice;

import com.itmd.exception.RaoraoBookShopException;
import com.itmd.vo.ExceptionResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(RaoraoBookShopException.class)
    public ResponseEntity<ExceptionResult> handleException(RaoraoBookShopException e){
        return ResponseEntity.status(e.getExceptionEnum().getCode()).body(new ExceptionResult(e.getExceptionEnum()));
    }
}
