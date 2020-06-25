package com.jda.covidconsumer.service;

import com.jda.covidconsumer.kafka.consumer.Message;
import com.jda.covidconsumer.kafka.consumer.MyDateTypeAdapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

import java.util.Date;

public class GsonTest {

  @Test
  public void testDeserialization() {
    String json = "{\"get\":\"statistics\",\"parameters\":{\"country\":\"India\"},\"errors\":[],\"results\":1.0," +
        "\"response\":[{\"country\":\"India\",\"cases\":{\"active\":22983.0,\"critical\":0.0,\"recovered\":7796.0," +
        "\"total\":31787.0},\"deaths\":{\"total\":1008.0},\"tests\":{\"total\":770764.0},\"day\":\"2020-04-29\"," +
        "\"time\":\"2020-04-29T14:15:12+00:00\"}]}";
    Gson gson  = new GsonBuilder().registerTypeAdapter(Date.class,new MyDateTypeAdapter()).create();
    Message obj = gson.fromJson(json, Message.class);
    System.out.println(obj);
  }
}
