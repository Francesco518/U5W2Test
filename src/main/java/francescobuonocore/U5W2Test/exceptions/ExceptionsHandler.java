package francescobuonocore.U5W2Test.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorsPayload messageErrorBadRequest(BadRequestException e) {
        return new ErrorsPayload(e.getMessage());
    }

    @ExceptionHandler(NotFoundExceptions.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorsPayload messageErrorNotFound(NotFoundExceptions exceptions) {
        return new ErrorsPayload(exceptions.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorsPayload messageInternalServerError(Exception e) {
        return new ErrorsPayload(e.getMessage());

    }
}
