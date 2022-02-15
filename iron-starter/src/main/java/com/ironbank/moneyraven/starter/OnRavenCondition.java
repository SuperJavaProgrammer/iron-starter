package com.ironbank.moneyraven.starter;

import org.springframework.boot.autoconfigure.condition.AllNestedConditions;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import static org.springframework.context.annotation.ConfigurationCondition.ConfigurationPhase.REGISTER_BEAN;

public class OnRavenCondition extends AllNestedConditions { //тут можно делать несколько @ConditionalOnProperty

  public OnRavenCondition() {
    super(REGISTER_BEAN);
  }

  @ConditionalOnProperty("crow.where") //прошлая аннотация
  public static class OnDestinationCondition {
  }

  @ConditionalOnProperty(value = "crow.include", havingValue = "true") //новая для нового свойства
  public static class OnEnabledCondition {
  }
}
