/*
package com.jda.covidconsumer.kafka.consumer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.FieldValueList;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobId;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.TableResult;
import java.util.UUID;

@Service
@Slf4j
public class ConsumerAgent {

  private static final BlockingQueue<String> B_QUEUE = new LinkedBlockingQueue<>(100);

  public static String getString() {
    try {
      return B_QUEUE.take();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return null;
  }

  @KafkaListener(topics = "#{'${kafka.topic}'}")
  public void consume(@Payload String message, @Headers MessageHeaders headers) {
    try {
      B_QUEUE.put(message);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    log.info(String.format("$$ -> Consumed Message -> %s", message));
    Gson gson  = new GsonBuilder().registerTypeAdapter(Date.class,new MyDateTypeAdapter()).create();
    Message obj = gson.fromJson(message, Message.class);
    log.info("#### Java obj : " + obj.toString());


    BigQuery bigquery = BigQueryOptions.getDefaultInstance().getService();

  }
}
*/
