package com.itmd.exception;

import com.itmd.enums.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RaoraoBookShopException extends RuntimeException{
    private ExceptionEnum exceptionEnum;
}
