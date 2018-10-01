package com.meusprojetos.apiproduto.advice;

import lombok.Data;

@Data
public class ResponseAdvice {

  private String code;
  private String description;

  public ResponseAdvice(String code, String description) {
    this.code = code;
    this.description = description;
  }

}
