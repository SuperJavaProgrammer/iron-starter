package com.ironbank.moneyraven.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties("ironbank")
public class ProphetProperties {
  List<String> теКтоВозвращаютДолги;
}
