package com.ironbank.moneyraven.service;

import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class NameBasedProphetService implements ProphetService { //реализация Пророка

  @Override
  public boolean willSurvive(String name) {
    return !name.contains("Stark") && LocalTime.now().getSecond() % 2 == 0; //определяет выживших по имени и четной секунде времени
  }

}
