package com.ironbank.moneyraven.starter;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

@RequiredArgsConstructor //как раз для создания конструктора
public class IronListener implements ApplicationListener<ContextRefreshedEvent> { //слушаем, когда произойдет событие обновления контекста
//  @Autowired //@Aurowired не обязателен тут, со Spring 4.3 его можно не ставить
  private final RavenProperties ravenProperties; //если существует один единственный конструктор, он и есть @Aurowired

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    System.out.println("Send a crow"); //и потом отправляем ворона
    ravenProperties.getWhere().forEach(s -> System.out.println("to " + s)); //получить и вывести свойства, куда отправляем
  }
}
