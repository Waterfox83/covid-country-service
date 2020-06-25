package com.jda.covidconsumer.api;

import com.jda.covidconsumer.api.stats.CountryStatsData;
import com.jda.covidconsumer.service.CovidCountryService;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
@RequestMapping(Routes.LATEST_VERSION)
public class CovidDataController {
  private final CovidCountryService covidCountryService;

  @Autowired
  public CovidDataController(CovidCountryService covidCountryService) {
    this.covidCountryService = covidCountryService;
  }

  @GetMapping(Routes.COUNTRY_STATS)
  public CountryStatsData getCountryStats(@RequestParam("country") String countryName) throws IOException {
    log.info("Calling covidCountryService.getCountryStats().");
    return covidCountryService.getCountryStats(countryName);
  }
}
