package com.mordor.backend.core.exception;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final MessageSource messageSource;

    public GlobalExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> handleMethodArgumentNotValid(
            MethodArgumentNotValidException exception
    ) {
        List<FieldError> fieldErrors =
                exception.getBindingResult().getFieldErrors();

        ValidationError validationError =
                processFieldErrors(fieldErrors);

        return ResponseEntity
                .badRequest()
                .body(validationError);
    }

    @ExceptionHandler(BusinessValidationException.class)
    public ResponseEntity<ValidationError> handleBusinessValidation(
            BusinessValidationException exception
    ) {
        String message = messageSource.getMessage(
                exception.getMessageCode(),
                null,
                LocaleContextHolder.getLocale()
        );

        ValidationError validationError = new ValidationError();

        validationError.addFieldError(
                exception.getField(),
                message
        );

        return ResponseEntity
                .badRequest()
                .body(validationError);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleResourceNotFound( ResourceNotFoundException exception){
        ApiError apiError = processApiError(exception.getMessageCode());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }


    private ValidationError processFieldErrors(
            List<FieldError> fieldErrors
    ) {
        ValidationError validationError = new ValidationError();

        for (FieldError fieldError : fieldErrors) {
            String message = messageSource.getMessage(
                    fieldError,
                    LocaleContextHolder.getLocale()
            );

            validationError.addFieldError(
                    fieldError.getField(),
                    message
            );
        }

        return validationError;
    }

    private ApiError processApiError(String messageCode) {

        String message = messageSource.getMessage(
                messageCode,
                null,
                LocaleContextHolder.getLocale()
        );

        return new ApiError(message);
    }


}