package com.ironbank.moneyraven.starter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //наш конфигурационный класс
public class IronConfiguration {

  @Bean
  public IronListener ironListener() {
    return new IronListener();
  }

}
