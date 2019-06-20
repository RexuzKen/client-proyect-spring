package clientproyectspring.clientproyectspring.exceptions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


import org.springframework.web.bind.MethodArgumentNotValidException;

@ControllerAdvice
public class ApiExceptionHandler {


    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler({         
            org.springframework.security.access.AccessDeniedException.class,
            
    })
    @ResponseBody
    public void unauthorizedRequest(HttpServletRequest request, Exception exception) {
        //Empty. Nothing to do
    }
    
    /*    
        @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({
            //ConflictException.class
    })
    @ResponseBody
    public ErrorMessage conflict(HttpServletRequest request, Exception exception) {
        return new ErrorMessage(exception, request.getRequestURI());
    }


    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler({
            //ForbiddenException.class
    })
    @ResponseBody
    public ErrorMessage forbidden(HttpServletRequest request, Exception exception) {
        return new ErrorMessage(exception, request.getRequestURI());
    }
    
*/

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({
            NotFoundException.class,
            UsernameNotFoundException.class,
            clientproyectspring.clientproyectspring.exceptions.ResourceNotFoundException.class
    })
    @ResponseBody
    public ErrorMessage notFoundRequest(HttpServletRequest request, Exception exception) {
        return new ErrorMessage(exception, request.getRequestURI());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            BadRequestException.class,
            org.springframework.dao.DuplicateKeyException.class,
            org.springframework.web.HttpRequestMethodNotSupportedException.class,
            MethodArgumentNotValidException.class,
            org.springframework.web.bind.MissingServletRequestParameterException.class,
            org.springframework.web.method.annotation.MethodArgumentTypeMismatchException.class,
            org.springframework.http.converter.HttpMessageNotReadableException.class,
            org.springframework.security.authentication.BadCredentialsException.class
    })
    @ResponseBody
    public ErrorMessage badRequest(HttpServletRequest request, Exception exception) {
    	
    	if (exception instanceof MethodArgumentNotValidException) {   		
    		String message = ""; 
    		BindingResult br  = ((MethodArgumentNotValidException)exception).getBindingResult();
  	
    		for (FieldError error : br.getFieldErrors()) {
				message += error.getDefaultMessage();
			}
    		return new ErrorMessage(exception.getClass().getSimpleName(), message, request.getRequestURI());
    	}
        return new ErrorMessage(exception, request.getRequestURI());
    }
    



    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({
            Exception.class
    })
    @ResponseBody
    public ErrorMessage exception(HttpServletRequest request, Exception exception) {
        LogManager.getLogger(this.getClass()).debug(">>> EXCEPTION  ..." + exception.toString());
        return new ErrorMessage(exception, request.getRequestURI());
    }

}
