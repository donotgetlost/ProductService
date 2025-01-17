package com.pramod.productservice.exceptionhandlers;


import com.pramod.productservice.dtos.ExceptionDto;
import com.pramod.productservice.dtos.ProductNotFoundExceptionDto;
import com.pramod.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDto> handleArithmeticException() {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("ArithmeticException");
        exceptionDto.setResolution("Nothing can be done");
        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity<>(exceptionDto,HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<Void> handleArrayIndexOutOfBoundsException() {
        ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundExceptionDto> handleProductNotFoundException(ProductNotFoundException e) {
         ProductNotFoundExceptionDto productNotFoundExceptionDto = new ProductNotFoundExceptionDto();
         productNotFoundExceptionDto.setMessage("ProductNotFoundException for id "+e.getId());
        ResponseEntity<ProductNotFoundExceptionDto> responseEntity = new ResponseEntity<>(productNotFoundExceptionDto,HttpStatus.NOT_FOUND);
        return responseEntity;
    }
}
