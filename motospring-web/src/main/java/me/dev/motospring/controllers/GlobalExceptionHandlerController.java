package me.dev.motospring.controllers;

import lombok.extern.slf4j.Slf4j;
import me.dev.motospring.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandlerController {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView handleNotFound() {
        log.error("NotFoundException caught");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error/404.html");
        return modelAndView;
    }
}
