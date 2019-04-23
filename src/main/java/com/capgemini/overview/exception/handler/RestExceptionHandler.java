package com.capgemini.overview.exception.handler;

import com.capgemini.overview.exception.VehiculeNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import static org.springframework.http.ResponseEntity.notFound;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {

    @ExceptionHandler(value = {VehiculeNotFoundException.class})
    public ResponseEntity vehiculeNotFound(
            VehiculeNotFoundException ex,
            WebRequest req) {

        log.debug("Handling VehiculeNotFoundException. Message : " + ex.getMessage() );
        return notFound().build();
        //Custom status response : ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
}
