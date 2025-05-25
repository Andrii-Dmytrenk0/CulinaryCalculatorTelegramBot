package org.example.culinarycalculatortelegrambot.telegramapi;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public interface Connector {
    void send(SendMessage sendMessage);
}
