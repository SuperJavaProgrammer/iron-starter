package com.ironbank.moneyraven.starter;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Conditional(OnRavenCondition.class) //новая аннотация на несколько свойств Ворона
@interface ConditionalOnRaven {
}
