package com.ironbank.moneyraven.service;

import com.ironbank.moneyraven.ProfileConstants;
import com.ironbank.moneyraven.model.ProphetProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile(ProfileConstants.WINTER_HERE) //активировать бин только при наличии этого профиля
@RequiredArgsConstructor
public class WhiteListBasedProphetService implements ProphetService { //новый Пророк
  private final ProphetProperties prophetProperties;

  @Override
  public boolean willSurvive(String name) {
    return prophetProperties.getТеКтоВозвращаютДолги().contains(name); //который одобряет кредиты только тем, кто возвращает долги
  }

}
