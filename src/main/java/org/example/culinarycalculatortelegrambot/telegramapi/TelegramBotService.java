package org.example.culinarycalculatortelegrambot.telegramapi;

public interface TelegramBotService {
    void sendMessageToChat(Long chatId, String text);
}
