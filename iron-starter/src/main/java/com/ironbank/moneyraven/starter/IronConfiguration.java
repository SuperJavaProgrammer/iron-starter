package com.ironbank.moneyraven.starter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //наш конфигурационный класс
public class IronConfiguration {

  @Bean
  @ConditionalOnProduction //новая аннотация, будет активировать бин только при условии Production
  public IronListener ironListener() {
    return new IronListener();
  }

}
