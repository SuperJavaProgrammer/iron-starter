package com.ironbank.moneyraven.starter;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Conditional(OnProductionCondition.class) //ссылается на только что написанный класс, где есть метод, который должен вернуть true или false
@interface ConditionalOnProduction {
}
