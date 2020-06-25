package com.jda.covidconsumer.service;

import com.jda.covidconsumer.api.stats.CountryStatsData;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Slf4j
@Service
public class CovidCountryService {
  private final String HEADER_RAPIDAPI_HOST = "x-rapidapi-host";
  private final String HEADER_RAPIDAPI_KEY = "x-rapidapi-key";

  @Value("${covid19.statisticsApi}")
  private String coronavirusCountryStatisticsApiUrl;

  @Value("${rapidApiKey}")
  private String rapidApiKey;

  @Value("${covid19.rapidApiHost}")
  private String covid19RapidApiHost;

  public CountryStatsData getCountryStats(@RequestParam("country") String countryName) throws IOException {
    log.info("Invoking RapidAPI to get country data");
    CloseableHttpClient httpclient = HttpClients.createDefault();

    String parametrizedUrl = coronavirusCountryStatisticsApiUrl + "?country=" + countryName;
    HttpGet httpGet = new HttpGet(parametrizedUrl);
    httpGet.addHeader(HEADER_RAPIDAPI_HOST, covid19RapidApiHost);
    httpGet.addHeader(HEADER_RAPIDAPI_KEY, rapidApiKey);

    CloseableHttpResponse response = httpclient.execute(httpGet);

    CountryStatsData countryStatsData = null;
    try {
      HttpEntity entity = response.getEntity();
      String responseValue = EntityUtils.toString(entity);
      countryStatsData = (new Gson()).fromJson(responseValue, CountryStatsData.class);
      log.info("Response: " + countryStatsData.toString());
    } finally {
      response.close();
    }

    return countryStatsData;
  }

}
