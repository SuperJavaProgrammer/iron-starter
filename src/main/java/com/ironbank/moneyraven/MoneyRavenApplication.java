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
 * https://habr.com/ru/company/jugru/blog/425333/
 Объект environment — это единственное, что существует на момент, когда Spring Boot начинает строить контекст.
 Сюда заходят разные property, профили.
 До ApplicationContextInitializer есть только EnvironmentPostProcessor.
 Кто запускает EnvironmentPostProcessor? ConfigFileApplicationListener
 Ему Spring Application дает подготовленный environment, чтобы тот слушал два event:
 ApplicationPreparedEvent и ApplicationEnvironmentPreparedEvent
 Получив ApplicationEnvironmentPreparedEvent, listener понимает, что надо настроить environment —
 найти все EnvironmentPostProcessor и дать им отработать.
 После этого он говорит SpringFactoriesLoader доставить все, что вы прописали,
 а именно все EnvironmentPostProcessor, в spring.factories. Потом он запихивает все EnvironmentPostProcessor в один List
 и понимает, что он тоже EnvironmentPostProcessor (по совместительству), поэтому и себя туда запихивает,
 при этом сортирует их, едет вместе с ними и вызывает у каждого метод postProcessEnvironment.
 Таким образом все postProcessEnvironment запускаются на раннем этапе еще до SpringApplicationInitializer
 Когда environment настроился, все опять возвращается к Spring Application.
 Если environment готов, можно строить контекст. И Spring Application начинает строить контекст с помощью ApplicationInitializer
 ConfigFileApplicationListener как EnvironmentPostProcessor он умеет
 подгружать application.yml, application properties, всякие environment variable, command аргументы и т.д.
 А как listener, он умеет слушать два event-а: ApplicationPreparedEvent, ApplicationEnvironmentPreparedEvent
 ctx.start(); -> ContextStartedEvent
 ctx.stop(); -> ContextStoppedEvent
 Вызывать ctx.stop(); перед ctx.start(); — можно (просто Spring игнорирует эти event-ы  - они только для вас).
 Синий — это Spring Boot, приложение уже стартовало. Это значит, что обрабатываются Tomcat service запросы, которые приходят
 к нему от клиентов, весь контекст точно поднят, все бины работают, базы данных подключены и т.д.
 Зеленый — прилетел event ContextRefreshedEvent и контекст построен. С этого момента начинают работать, например, application
 listener-ы, которые вы имплементируете либо путем установки аннотации ApplicationListener, либо через одноименный интерфейс
 с дженериком, который слушает определенные event-ы. Если же вы хотите получать больше event-ов, нужно прописывать этот же
 ApplicationListener в spring.factories (здесь работает обычный Spring). Полосой отмечено, где начинается доклад Spring Ripper.
 На более ранней стадии работает SpringApplication, который подготавливает нам контекст. Это та работа по подготовке приложения,
 которую мы делали, когда были обычными Spring-разработчиками. Например, конфигурировали WebXML.
 Но есть еще более ранние этапы. Здесь указано, кто, где и за кем работает.
 Есть еще серый этап, в которой никак нельзя вклиниться. Это этап, на котором "из коробки" работает SpringApplication (только в код лезть).

 Вы пишите в вашем main SpringApplication.run. Он находит разных listener-ов, кидает им event, что начал строиться.
 После этого listener-ы находят EnvironmentPostProcessor, дают им настроить environment.
 Как только environment настроен, мы начинаем строить контекст (вступает Карлсон). Карлсон строит контекст и дает возможность
 всем Application Initializer-ам что-то с этим контекстом сделать. У нас есть точка расширения. После этого контекст уже настроен
 и дальше начинает происходить то же самое, что и в обычном Spring-овом приложении, когда строиться контекст —
 BeanFactoryPostProcessor, BeanPostProcessor, бины настраиваются. Этим занимается обычный Spring.

 Как запускать: tomcat war; idea; java -jar/war.
 executable jar:
 <plugin>
 <groupId>org.springframework.boot</groupId>
 <artifactId>spring-boot-maven-plugin</artifactId>
 <configuration>
 <executable>true</executable>
 </configuration>
 </plugin>
 */