package edu.cnm.deepdive.server;

import org.springframework.boot.builder.SpringApplicationBuilder;

public class ServerLauncher {

  public static void main(String[] args) {
    new SpringApplicationBuilder()
        .sources(HomesteadServerApplication.class)
        .profiles("server")
        .run(args);
  }

}
