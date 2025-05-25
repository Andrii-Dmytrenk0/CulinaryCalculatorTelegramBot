package org.example.culinarycalculatortelegrambot.telegramapi;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public interface TelegramBotService {
    void send(SendMessage sendMessage);
}
