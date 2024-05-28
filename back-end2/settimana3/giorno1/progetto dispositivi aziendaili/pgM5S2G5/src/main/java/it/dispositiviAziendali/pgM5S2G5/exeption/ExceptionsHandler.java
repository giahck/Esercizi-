package it.dispositiviAziendali.pgM5S2G5.exeption;

import it.dispositiviAziendali.pgM5S2G5.payloads.ErrorPaylod.ErrorDeiPayload;
import it.dispositiviAziendali.pgM5S2G5.payloads.ErrorPaylod.ErrorsPayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestControllerAdvice
@Slf4j
public class ExceptionsHandler{
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDeiPayload handleBadRequest(BadRequestException e) {
        List<String> errorsMessages = new ArrayList<>();
        if (e.getErrorsList() != null)
            errorsMessages = e.getErrorsList().stream().map(err -> err.getDefaultMessage()).toList();
        return new ErrorDeiPayload(e.getMessage(), new Date(), errorsMessages);
    }
    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorsPayload handleNotFound(ChangeSetPersister.NotFoundException e) {
        return new ErrorsPayload(e.getMessage(), new Date());
    }
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorsPayload handleRuntimeException(RuntimeException e) {
        return new ErrorsPayload(e.getMessage(), new Date());
    }
}
