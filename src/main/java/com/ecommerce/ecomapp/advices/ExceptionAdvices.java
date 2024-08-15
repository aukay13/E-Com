package com.ecommerce.ecomapp.advices;

import com.ecommerce.ecomapp.DTOs.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class ExceptionAdvices {

    private final ErrorResponseDTO responseDTO;
    public ExceptionAdvices(ErrorResponseDTO responseDTO){
        this.responseDTO = responseDTO;
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDTO handleNotFoundException(RuntimeException e){
//        ErrorResponseDTO responseDTO = new ErrorResponseDTO();
        responseDTO.setStatus("Error");
        responseDTO.setMessage(e.getMessage());
        return responseDTO;
    }


}
