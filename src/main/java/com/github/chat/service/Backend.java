package com.github.chat.service;


import com.github.chat.model.Health;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Backend {
    private RestTemplate restTemplate = new RestTemplate();
    public static void main(String[] args) {
        Backend backend = new Backend();
        System.out.println(backend.checkHealth().isHealth());
    }
    public Health checkHealth(){
        ResponseEntity<Health> healthResponseEntity = restTemplate.getForEntity(
          "https://d1fuzbayh0.execute-api.eu-central-1.amazonaws.com/prod", Health.class
        );
        Health health = healthResponseEntity.getBody();
        return health;
    }
}
