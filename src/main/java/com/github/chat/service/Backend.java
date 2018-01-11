package com.github.chat.service;


import com.github.chat.model.Health;
import com.github.chat.model.Weather;
import com.sun.javafx.binding.StringFormatter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Backend {
    private RestTemplate restTemplate = new RestTemplate();

    public Health checkHealth(){
        ResponseEntity<Health> healthResponseEntity = restTemplate.getForEntity(
          "https://d1fuzbayh0.execute-api.eu-central-1.amazonaws.com/prod", Health.class
        );
        Health health = healthResponseEntity.getBody();
        return health;
    }
    public Weather checkWeather() {
        ResponseEntity <Weather> weatherResponseEntity = restTemplate.getForEntity(
                "https://d1fuzbayh0.execute-api.eu-central-1.amazonaws.com/prod/weather", Weather.class
        );
        Weather weather = weatherResponseEntity.getBody();
        return weather;
    }
}
