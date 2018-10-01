package com.meusprojetos.apiproduto.controllers;

import com.meusprojetos.apiproduto.advice.ResponseAdvice;
import com.meusprojetos.apiproduto.service.MessageTokenLocaleService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.NoSuchMessageException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestTokenControllerAdvice {

  private final MessageTokenLocaleService messageTokenLocaleService;

  @Autowired
  public RestTokenControllerAdvice(MessageTokenLocaleService messageTokenLocaleService) {
    this.messageTokenLocaleService = messageTokenLocaleService;
  }

  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseAdvice handleException(IllegalArgumentException ex) {
    return new ResponseAdvice(ex.getMessage(),
        this.messageTokenLocaleService.getMessage(ex.getMessage()));
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public List<ResponseAdvice> handleExceptionConstraint(MethodArgumentNotValidException ex) {

    List<ResponseAdvice> errors = new ArrayList<ResponseAdvice>();

    ex.getBindingResult().getAllErrors().stream().forEach(p -> {
      try {
        errors.add(new ResponseAdvice(p.getDefaultMessage(),
            this.messageTokenLocaleService.getMessage(p.getDefaultMessage())));
      } catch (NoSuchMessageException e) {
        errors.add(new ResponseAdvice(p.getDefaultMessage(), "invalid request"));
      }
    });

    return errors;
  }

}
