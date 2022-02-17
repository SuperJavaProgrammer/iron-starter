package com.ironbank.moneyraven.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;

public class ResolveProfileEnvironmentPostProcessor implements EnvironmentPostProcessor {
  @Override
  public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
    if (environment.getActiveProfiles().length > 0)
      return;
    environment.setActiveProfiles(getTemperature() < -272 ? "winterHere" : "winterClose");
  }

  private int getTemperature() {
    return -300;
  }
}
