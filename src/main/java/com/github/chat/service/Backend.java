package com.github.chat.service;


import com.github.chat.model.Health;
import com.github.chat.model.Message;
import com.github.chat.model.User;
import com.github.chat.model.Weather;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

public class Backend {
  private RestTemplate restTemplate = new RestTemplate();

  //    private String url = "http://rest.metraf.eu";
  private String url = "http://localhost:8080";

  private String token = "EzCXxjmQMjxBdQaNHbyiZwoiwrFdnyxXQqKnNywJ3JwL";

  public Health checkHealth() {
    final ResponseEntity<Health> healthResponseEntity = restTemplate.getForEntity(
        url + "/", Health.class
    );
    Health health = healthResponseEntity.getBody();
    return health;
  }

  public Weather checkWeather() {
    final ResponseEntity<Weather> weatherResponseEntity = restTemplate.getForEntity(
        "https://d1fuzbayh0.execute-api.eu-central-1.amazonaws.com/prod/weather", Weather.class
    );
    Weather weather = weatherResponseEntity.getBody();
    return weather;
  }

  public List<Message> getMessages() {
    ParameterizedTypeReference<List<Message>> listParameterizedTypeReference = new ParameterizedTypeReference<List<Message>>() {
    };
    final ResponseEntity<List<Message>> listResponseEntity = restTemplate.exchange(url + "/message", HttpMethod.GET, null, listParameterizedTypeReference);
    return listResponseEntity.getBody();
  }

  public Message setMessage(Message message) {
    ParameterizedTypeReference<Message> reference = new ParameterizedTypeReference<Message>() {
    };
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.add("x-auth-token", token);
    final ResponseEntity<Message> messageResponseEntity = restTemplate.exchange(url + "/message", HttpMethod.POST, new HttpEntity<>(message), reference);
    return messageResponseEntity.getBody();
  }

  public static void main(String[] args) {
    Backend backend = new Backend();
    System.out.println(backend.checkHealth().isStatus());
    System.out.println(backend.checkWeather().getName());
    System.out.println(backend.setMessage(backend.createSimpleMessage()).getMessage());
    System.out.println("get messages");
    for (Message message : backend.getMessages()) {
      System.out.println(message.getMessage());
    }
  }

  private Message createSimpleMessage() { //just for test
    Message message = new Message();
    User user = new User("erika", "#000000");
    message.setUser(user);
    message.setMessage("some another message");
    message.setLocaltime(LocalDateTime.now());
    return message;
  }
}
