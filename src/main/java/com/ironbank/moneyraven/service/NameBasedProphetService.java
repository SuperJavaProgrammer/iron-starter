package com.ironbank.moneyraven.service;

import com.ironbank.moneyraven.ProfileConstants;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
@Profile(ProfileConstants.WINTER_CLOSE) //активировать бин только при наличии этого профиля, уже другого
public class NameBasedProphetService implements ProphetService { //реализация Пророка

  @Override
  public boolean willSurvive(String name) {
    return !name.contains("Stark") && LocalTime.now().getSecond() % 2 == 0; //определяет выживших по имени и четной секунде времени
  }

}
