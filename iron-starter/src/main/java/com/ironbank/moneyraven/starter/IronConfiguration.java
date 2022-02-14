package com.ironbank.moneyraven.starter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //наш конфигурационный класс
@EnableConfigurationProperties(RavenProperties.class) //использовать файл настроек класса RavenProperties
public class IronConfiguration {

  @Bean
  @ConditionalOnProduction //новая аннотация, будет активировать бин только при условии Production
  @ConditionalOnProperty("crow.where") //аннотация, будет активировать бин только при условии наличия свойства(даже если у него нет значения)
  public IronListener ironListener(RavenProperties r) {
    return new IronListener(r);
  }

}
