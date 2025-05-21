package org.example.culinarycalculatortelegrambot.telegramapi.telegramcontrollers;

import org.example.culinarycalculatortelegrambot.config.TelegramBotProperties;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class CommunicationWithTelegramBot extends TelegramLongPollingBot {

    private final TelegramBotProperties botProperties;

    public CommunicationWithTelegramBot(TelegramBotProperties botProperties) {
        this.botProperties = botProperties;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String text = update.getMessage().getText().trim();
            long chatId = update.getMessage().getChatId();
            System.out.println("Chat ID: " + chatId);

            if (text.equalsIgnoreCase("ping")) {
                SendMessage response = new SendMessage();
                response.setChatId(String.valueOf(chatId));
                response.setText("pong");

                try {
                    execute(response);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public String getBotUsername() {
        return botProperties.getUsername();
    }

    @Override
    public String getBotToken() {
        return botProperties.getToken();
    }
}

