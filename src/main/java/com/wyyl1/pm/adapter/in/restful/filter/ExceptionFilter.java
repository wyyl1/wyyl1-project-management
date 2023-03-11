package com.wyyl1.pm.adapter.in.restful.filter;

import com.wyyl1.pm.common.exception.BizException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Objects;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionFilter {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> exceptionHandler(Exception e) {
        if (e instanceof BindException) {
            BindingResult bindingResult = ((BindException) e).getBindingResult();

            if (bindingResult.hasErrors()) {
                return new ResponseEntity<>(createAllErrors(bindingResult), HttpStatus.BAD_REQUEST);
            }
        }

        if (e instanceof BizException) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        if (e instanceof IllegalArgumentException) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("呵呵报错了", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private static String createAllErrors(BindingResult bindingResult) {
        return bindingResult.getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .filter(Objects::nonNull)
                .collect(Collectors.joining("\n"));
    }

}
