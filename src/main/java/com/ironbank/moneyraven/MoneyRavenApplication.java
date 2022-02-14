package com.ironbank.moneyraven;

import com.ironbank.moneyraven.model.ProphetProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ProphetProperties.class)
public class MoneyRavenApplication {
  public static void main(String[] args) {
    SpringApplication.run(MoneyRavenApplication.class, args);
  }
}
/**
 Данные в файлах application.properties и application.yml
 Удобные аннотации для фильтрации условий:
 @ConditionalOnBean
 @ConditionalOnClass
 @ConditionalOnCloudPlatform
 @ConditionalOnExpression
 @ConditionalOnJava
 @ConditionalOnJndi
 @ConditionalOnMissingBean
 @ConditionalOnMissingClass
 @ConditionalOnNotWebApplication
 @ConditionalOnProperty //это подходит
 @ConditionalOnResource
 @ConditionalOnSingleCandidate
 @ConditionalOnWebApplication
 */