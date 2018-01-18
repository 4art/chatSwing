package com.github.chat.service;


import com.github.chat.model.Health;
import com.github.chat.model.Message;
import com.github.chat.model.User;
import com.github.chat.model.Weather;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

public class BackendImpl implements Backend{
  private RestTemplate restTemplate = new RestTemplate();

  private String url = "http://safechat.metraf.eu";
//  private String url = "http://localhost:8080";

  private String token = "EzCXxjmQMjxBdQaNHbyiZwoiwrFdnyxXQqKnNywJ3JwL";

  @Override
  public Health checkHealth() {
    final ResponseEntity<Health> healthResponseEntity = restTemplate.getForEntity(
        url + "/", Health.class
    );
    Health health = healthResponseEntity.getBody();
    return health;
  }

  @Override
  public Weather checkWeather() {
    final ResponseEntity<Weather> weatherResponseEntity = restTemplate.getForEntity(
        "https://d1fuzbayh0.execute-api.eu-central-1.amazonaws.com/prod/weather", Weather.class
    );
    Weather weather = weatherResponseEntity.getBody();
    return weather;
  }

  @Override
  public List<Message> getMessages() {
    ParameterizedTypeReference<List<Message>> listParameterizedTypeReference = new ParameterizedTypeReference<List<Message>>() {
    };
    final ResponseEntity<List<Message>> listResponseEntity = restTemplate.exchange(url + "/message", HttpMethod.GET, new HttpEntity<>(getHeaders()), listParameterizedTypeReference);
    return listResponseEntity.getBody();
  }

  @Override
  public Message setMessage(Message message) {
    ParameterizedTypeReference<Message> reference = new ParameterizedTypeReference<Message>() {
    };
    final ResponseEntity<Message> messageResponseEntity = restTemplate.exchange(url + "/message", HttpMethod.POST, new HttpEntity<>(message, getHeaders()), reference);
    return messageResponseEntity.getBody();
  }

  private Message createSimpleMessage() { //just for test
    Message message = new Message();
    User user = new User("erika", "#000000");
    message.setUser(user);
    message.setMessage("some another message");
    message.setLocaltime(LocalDateTime.now(ZoneId.of("Europe/Paris")));
    return message;
  }

  private HttpHeaders getHeaders() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.add("x-auth-token", token);
    return headers;
  }
}
