package com.ironbank.moneyraven.starter;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

//ApplicationContextInitializer работает, когда контекст только начинает строиться, еще нет никаких бинов. Отрабатывает, когда контекст уже создан, но еще в нем нет ничего, кроме environment.
public class ProfileCheckAppInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
  @Override
  public void initialize(ConfigurableApplicationContext applicationContext) {
    if (applicationContext.getEnvironment().getActiveProfiles().length == 0) {
      throw new RuntimeException("It is forbidden without a Profile!");
    }
  }
}
