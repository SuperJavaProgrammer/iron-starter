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
 spring.factories
 В этом файле мы прописываем, какая конфигурация у этого стартера должна быть активизирована у всех, кто его подгрузил.
 Spring Boot — в какой-то момент он начинает сканировать все jar-ы и искать файл spring.factories.
 org.springframework.boot.autoconfigure.EnableAutoConfiguration=com.ironbank.IronConfiguration

 @SpringBootApplication
 @Configuration, то есть это конфигурация. Там можно написать @Bean и как обычно прописывать бины.
 @ComponentScan. По умолчанию он сканирует абсолютно все пакеты и подпакеты. Соответственно, если вы в том же пакете или в его подпакетах начинаете создавать сервисы — @Service, @RestController — они автоматически сканируются, поскольку процесс сканирования запускает ваша главная конфигурация.
 @EnableAutoConfiguration. Именно этот класс был прописан в spring.factories.
 Он несет с собой @Import. ImportSelector протаскивает все наши стартеры в контекст.  Он обрабатывает аннотацию @EnableAutoConfiguration из spring.factories, которая выбирает, какие конфигурации загрузить, и добавляет в контекст те бины, которые мы прописали в IronConfiguration.
 Есть зависимость org.springframework.boot:spring-boot-autoconfigure(jar самого Spring Boot). В ней подключено 90 конфигураций. Они бы загружались, если бы не @Conditional. Из-за него бины либо создаются, либо нет.
 */