package edu.cnm.deepdive.server;

import org.springframework.boot.builder.SpringApplicationBuilder;

public class PreloadLauncher {

    public static void main(String[] args) {
      new SpringApplicationBuilder()
          .sources(HomesteadServerApplication.class)
          .profiles("preload")
          .run(args);
    }
  }
