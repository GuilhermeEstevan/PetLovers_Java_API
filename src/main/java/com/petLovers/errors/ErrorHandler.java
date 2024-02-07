package com.petLovers.errors;

import com.petLovers.dto.errors.ErrorDetailsDTO;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.ObjectNotFoundException;
import org.postgresql.util.PSQLException;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        var simpleErrorMsg = new simpleErrorMsg(e.getMessage());
        return ResponseEntity.badRequest().body(simpleErrorMsg);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException e) {
        var errorDetailsDTO = new ErrorDetailsDTO("Id não encontrado", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetailsDTO);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleBadRequestException(MethodArgumentNotValidException e) {
        var errors = e.getFieldErrors();
        List<errorsData> errorsDataList = errors.stream().map(errorsData::new).toList();
        return ResponseEntity.badRequest().body(errorsDataList);
    }

    public record errorsData(String msg, String field) {

        public errorsData(FieldError error) {

            this(error.getDefaultMessage(), error.getField());
        }
    }

    public record simpleErrorMsg(String msg) {
        public simpleErrorMsg(String msg) {
            this.msg = msg;
        }
    }
}
