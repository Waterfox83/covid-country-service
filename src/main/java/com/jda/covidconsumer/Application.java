package com.jda.covidconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//CSOFF: HideUtilityClassConstructor
@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  public static final class Profiles {
    public static final String TEST = "test";
  }

}
//CSON: HideUtilityClassConstructor
