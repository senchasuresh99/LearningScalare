package com.scalar.ecom.globalException;

import com.scalar.ecom.dtos.ExceptionDto;
import com.scalar.ecom.exceptions.InvalidTokenException;
import com.scalar.ecom.exceptions.PasswordMismatchException;
import com.scalar.ecom.exceptions.UserAlreadyExistException;
import com.scalar.ecom.exceptions.UserNotSignedUpException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(PasswordMismatchException.class)
    public ResponseEntity<ExceptionDto> handlePasswordMismatchException(PasswordMismatchException e){
        return new ResponseEntity<>(new ExceptionDto("Error", e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AuthorizationDeniedException.class)
    public ResponseEntity<ExceptionDto> handleAuthorizationDeniedException(PasswordMismatchException e){
        return new ResponseEntity<>(new ExceptionDto("Error", e.getMessage()), HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<ExceptionDto> handleUserAlreadyExistException(UserAlreadyExistException e){
        return new ResponseEntity<>(new ExceptionDto("Error", e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserNotSignedUpException.class)
    public ResponseEntity<ExceptionDto> handleUserNotSignedUpException(UserNotSignedUpException e){
        return new ResponseEntity<>(new ExceptionDto("Error", e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<ExceptionDto> handleInvalidTokenException(InvalidTokenException e){
        return new ResponseEntity<>(new ExceptionDto("Error", e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionDto> handleRuntimeException(RuntimeException e){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage(e.getMessage());
        exceptionDto.setStatus("Error");
        return new ResponseEntity<>(exceptionDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
