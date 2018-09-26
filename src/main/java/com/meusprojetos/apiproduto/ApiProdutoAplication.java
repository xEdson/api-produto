package com.meusprojetos.apiproduto;

import java.util.Locale;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class ApiProdutoAplication {

  public static void main(String[] args) {
    SpringApplication.run(ApiProdutoAplication.class, args);
  }


  @Bean
  public LocaleResolver localeResolver() {
    SessionLocaleResolver slr = new SessionLocaleResolver();

    slr.setDefaultLocale(Locale.forLanguageTag("pt-BR"));
    // slr.setDefaultLocale(Locale.forLanguageTag("en-US"));

    return slr;
  }

  @Bean
  public ReloadableResourceBundleMessageSource messageSource() {
    ReloadableResourceBundleMessageSource messageSource =
        new ReloadableResourceBundleMessageSource();
    messageSource.setBasename("classpath:Locale/messages");
    messageSource.setCacheSeconds(3600);
    return messageSource;
  }
}
