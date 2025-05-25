package org.example.culinarycalculatortelegrambot.telegramapi;

import org.example.culinarycalculatortelegrambot.config.BotConfiguration;
import org.example.culinarycalculatortelegrambot.telegramapi.telegramcontrollers.UpdateHandler;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class TelegramBotConnector extends TelegramLongPollingBot implements Connector {

    private final BotConfiguration config;
    private final UpdateHandler updateHandler;

    public TelegramBotConnector(BotConfiguration config, @Lazy UpdateHandler updateHandler) {
        this.config = config;
        this.updateHandler = updateHandler;
    }

    @Override
    public void send(SendMessage message) {
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return config.getUsername();
    }

    @Override
    public String getBotToken() {
        return config.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        updateHandler.handle(update);
    }
}
