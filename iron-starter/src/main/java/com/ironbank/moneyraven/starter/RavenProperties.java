package com.ironbank.moneyraven.starter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties("crow") //брать настройки по значению "crow", кириллица не работает
public class RavenProperties {
  List<String> where; //получить и заполнить список всех значений "where"
}
