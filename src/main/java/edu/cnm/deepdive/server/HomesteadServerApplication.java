package edu.cnm.deepdive.server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;

@SpringBootApplication
@EnableHypermediaSupport(type = HypermediaType.HAL)
public class HomesteadServerApplication {

  @Value("${oauth.clientId}")
  private String clientId;
  public static void main(String[] args) {
    SpringApplication.run(HomesteadServerApplication.class, args);
  }
}
