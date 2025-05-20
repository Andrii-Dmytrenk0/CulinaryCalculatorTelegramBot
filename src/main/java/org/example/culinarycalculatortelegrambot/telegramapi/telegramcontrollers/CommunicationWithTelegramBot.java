package org.example.culinarycalculatortelegrambot.telegramapi.telegramcontrollers;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class CommunicationWithTelegramBot extends TelegramLongPollingBot {

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
        return "CulinaryCalculatorTelegramBot"; // Замените на имя вашего бота
    }

    @Override
    public String getBotToken() {
        return "8091928144:AAHgLtW5mIIcLYKYYCVNODL7aHgQCGHas9g"; // Ваш токен
    }
}

