package com.va.laundryjunction.config;

import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LaundryJunctionBeanConfig {

  @Bean
  public Algorithm laundrtyJunctionHmacAlgorithm(){
    // TODO:
    // fetch this secret from secret map of cloud.
    return Algorithm.HMAC512("secret");
  }

}
