package com.pedro.helpdesk.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler   {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StanderError> objectNotFound(ObjectNotFoundException ex,
                                                       HttpServletRequest request    ) {

        StanderError error = new StanderError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
                "registro não encontrado", request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
