package com.ecommerce.ecomapp.advices;

import com.ecommerce.ecomapp.DTOs.ErrorResponseDTO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvices {

    @ExceptionHandler(RuntimeException.class)
    public ErrorResponseDTO handleRuntimeExceptions(RuntimeException e){
        ErrorResponseDTO responseDTO = new ErrorResponseDTO();
        responseDTO.setStatus("ERROR");
        responseDTO.setMessage(e.getMessage());
        return responseDTO;
    }
}
