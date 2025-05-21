package org.example.culinarycalculatortelegrambot.telegramapi;

import org.example.culinarycalculatortelegrambot.config.TelegramBotProperties;
import org.example.culinarycalculatortelegrambot.telegramapi.telegramcontrollers.UpdateHandler;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class TelegramBotServiceImpl extends TelegramLongPollingBot implements TelegramBotService {

    private final TelegramBotProperties properties;
    private final UpdateHandler updateHandler;

    public TelegramBotServiceImpl(TelegramBotProperties properties,@Lazy UpdateHandler updateHandler) {
        this.properties = properties;
        this.updateHandler = updateHandler;
    }

    @Override
    public void sendMessageToChat(Long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(text);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return properties.getUsername();
    }

    @Override
    public String getBotToken() {
        return properties.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        updateHandler.handleUpdate(update);
    }
}
