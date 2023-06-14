package ms.kx.Application.controllerAdvice;

import ms.kx.Application.exceptions.PhoneNumberException;
import ms.kx.Application.exceptions.UserNameException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class UserControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {UserNameException.class})
    public ResponseEntity<Object> UserNameException(Exception e, WebRequest webRequest){
        String message = "First Name Or Last Name Must Not Be Empty";

        return handleExceptionInternal(e, message, new HttpHeaders(), HttpStatus.CONFLICT, webRequest);
    }

    @ExceptionHandler(value = {PhoneNumberException.class})
    public ResponseEntity<Object> PhoneNumberException(Exception e, WebRequest webRequest){
        String message = "Phone Number Must To Start With 0 And Have No More Than 9 Digits";

        return handleExceptionInternal(e, message, new HttpHeaders(), HttpStatus.CONFLICT, webRequest);
    }
}
