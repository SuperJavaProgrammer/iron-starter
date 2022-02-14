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
 В стартерах все есть, и конфликтов версий нет
 'org.springframework.boot:spring-boot-starter-web'
 'org.springframework.boot:spring-boot-starter-data-jpa'
 'com.h2database:h2'

 Раньше был контекст, передавали файлы настройки, а в Буте иначе - он помечен мощной аннотацией @SpringBootApplication.
 SpringApplication - Карлсон
 Он делает только два вида контекста: либо web-контекст (WebApplicationContext) (если в classpath есть Servlet+ConfigurableWebApplicationContext), либо дженерик-контекст (AnnotationConfigApplicationContext).
 Уже сразу почти 500 бинов есть в SpringApplication после подключения 3-4 стартеров
 run.getBeanDefinitionName()
 */