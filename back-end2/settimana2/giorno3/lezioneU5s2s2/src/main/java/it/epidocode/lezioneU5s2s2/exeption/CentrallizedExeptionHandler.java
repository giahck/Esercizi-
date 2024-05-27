package it.epidocode.lezioneU5s2s2.exeption;

import it.epidocode.lezioneU5s2s2.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestControllerAdvice
public class CentrallizedExeptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(StudenteNonTrovatoException.class)
    public ResponseEntity<Object> StudenteNonTrovatoHandler(StudenteNonTrovatoException e){
        Error error=new Error();
        error.setMessage(e.getMessage());
        //error.getDataErrore(LocalDateTime.now());
        error.setStatoErrore(HttpStatus.NOT_FOUND);
     //   return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(BadRiquestException.class)
    public  ResponseEntity<Object> BadRiquestHandler(BadRiquestException e){
        Error error=new Error();
        error.setMessage(e.getMessage());
        error.setStatoErrore(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
