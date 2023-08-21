package com.example.CelluloidInsight.ExceptionHandling;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;
import java.time.LocalTime;
import java.util.Arrays;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ApiException.class})
    protected ResponseEntity<ApiError> handleApiException(ApiException ex) {
        return new ResponseEntity<>(new ApiError(ex.getStatus(), Arrays.asList(ex.getMessage()), LocalTime.now()), ex.getStatus());
    }
//    @ExceptionHandler(ConstraintViolationException.class)
//    ResponseEntity<ApiError> handleConstraintViolationException(ConstraintViolationException e) {
//        return new ResponseEntity<>(new ApiError(HttpStatus.BAD_REQUEST,Arrays.asList(e.getMessage()),Instant.now()),HttpStatus.BAD_REQUEST);
//    }
////    @ExceptionHandler({Exception.class})
////    public ResponseEntity<ApiError> handleAnyException(Exception exception,WebRequest request){
////        System.out.println("\u001B[35m" + exception.getLocalizedMessage() +"\u001B[0m");
////        return new ResponseEntity<>(new ApiError(HttpStatus.BAD_REQUEST, exception.toString(),Instant.now()),HttpStatus.BAD_REQUEST);
////    }

//    @Override
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
//        log.warn("\u001B[38m"  +"This methods gets Called!!"+ "\u001B[0m");
//        List<String> errors = new ArrayList<String>();
//
//        System.out.println("\u001B[31m" + ex.getBindingResult().getAllErrors()+"\u001B[0m" );
//        for (final FieldError error : ex.getBindingResult().getFieldErrors()) {
//            System.out.println("\u001B[31m" + ex.getBindingResult()+"\u001B[0m" );
//            errors.add(error.getDefaultMessage());
//            //errors.add(error.getField() + ": " + error.getDefaultMessage());
//        }
//        errors.addAll(List.of(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage().split(",")));
//
//
//        ApiError error = new ApiError(HttpStatus.BAD_REQUEST, errors,Instant.now());
//        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//        // return super.handleMethodArgumentNotValid(ex, headers, status, request);
//    }//2 3 3 3 2  //2 3 4 4 4 5 6 2

//    @Override
//    protected ResponseEntity<Object>  (Exception ex, Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
//        return super.handleExceptionInternal(ex, body, headers, statusCode, request);
//    }

}