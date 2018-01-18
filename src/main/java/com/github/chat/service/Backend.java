package com.github.chat.service;

import com.github.chat.model.Health;
import com.github.chat.model.Message;
import com.github.chat.model.Weather;

import java.util.List;

public interface Backend {
    Health checkHealth();

    Message setMessage(Message message);

    List<Message> getMessages();

    Weather checkWeather();
}
