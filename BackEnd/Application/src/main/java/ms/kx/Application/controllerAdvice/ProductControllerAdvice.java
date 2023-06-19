package ms.kx.Application.controllerAdvice;


import ms.kx.Application.exceptions.ProductNameException;
import ms.kx.Application.exceptions.ProductPriceException;
import ms.kx.Application.exceptions.ProductQuantityException;
import ms.kx.Application.exceptions.ProductSpecificationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ProductControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {ProductNameException.class})
    public ResponseEntity<Object> handlerProductNameException(RuntimeException e, WebRequest webRequest){
        String message = "Product Name Can Not Be Empty";

        return handleExceptionInternal(e, message, new HttpHeaders(), HttpStatus.CONFLICT, webRequest);
    }

    @ExceptionHandler(value = {ProductSpecificationException.class})
    public ResponseEntity<Object> handlerProductSpecificationException(RuntimeException e, WebRequest webRequest){
        String message = "Product Specification Can Not Be Empty";

        return handleExceptionInternal(e, message, new HttpHeaders(), HttpStatus.CONFLICT, webRequest);
    }

    @ExceptionHandler(value = {ProductPriceException.class})
    public ResponseEntity<Object> handlerProductPriceException(RuntimeException e, WebRequest webRequest){
        String message = "Product Price Can Not Be Less Than 0";

        return handleExceptionInternal(e, message, new HttpHeaders(), HttpStatus.CONFLICT, webRequest);
    }

    @ExceptionHandler(value = {ProductQuantityException.class})
    public ResponseEntity<Object> handlerProductQuantityException(RuntimeException e, WebRequest webRequest){
        String message = "Product Quantity Can Not Be Negative";

        return handleExceptionInternal(e, message, new HttpHeaders(), HttpStatus.CONFLICT, webRequest);
    }
}
