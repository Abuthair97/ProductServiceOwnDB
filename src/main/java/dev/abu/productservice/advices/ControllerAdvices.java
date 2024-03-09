package dev.abu.productservice.advices;

import dev.abu.productservice.Dtos.ErrorDto;
import dev.abu.productservice.exceptions.CategoryNotFoundException;
import dev.abu.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvices {
    @ExceptionHandler(ProductNotFoundException.class)
    ResponseEntity<ErrorDto> handleException(ProductNotFoundException productNotFoundException){
        ErrorDto dto = new ErrorDto();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Desc","Product Not Found Exception ");
        dto.setMessage(productNotFoundException.getMessage());
        return new ResponseEntity<>(dto,httpHeaders, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    ResponseEntity<ErrorDto> handleCategoryException(CategoryNotFoundException categoryNotFoundException){
        ErrorDto dto = new ErrorDto();
        HttpHeaders httpHeaders = new HttpHeaders();
        dto.setMessage(categoryNotFoundException.getMessage());
        return new ResponseEntity<>(dto,httpHeaders,HttpStatus.NOT_FOUND);
    }
}
