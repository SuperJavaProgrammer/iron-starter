package com.ironbank.moneyraven.starter;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Scanner;

public class OnProductionCondition implements Condition { //реализация проверки

  @Override
  public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
    boolean result;
    System.out.println("Is it Production? [true/false]");
    Scanner scanner = new Scanner(System.in);
    result = scanner.nextBoolean();
    System.out.println("Production=" + result);
    return result;
  }
}
