package com.ironbank.moneyraven.starter;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class IronListener implements ApplicationListener<ContextRefreshedEvent> { //слушаем, когда произойдет событие обновления контекста

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    System.out.println("Send a crow"); //и потом отправляем ворона
  }
}
