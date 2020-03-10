package edu.cnm.deepdive.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;

/**
 * Used to mark the ServerApplication class that one or more @Bean methods and triggers
 * auto-configuration and component scanning.
 */
@EnableHypermediaSupport(type = HypermediaType.HAL)
@SpringBootApplication
public class ServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(ServerApplication.class, args);
  }

}
