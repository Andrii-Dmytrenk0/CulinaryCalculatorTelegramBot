package org.example.culinarycalculatortelegrambot.telegramapi.telegramcontrollers;

import org.example.culinarycalculatortelegrambot.telegramapi.Connector;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class UpdateHandler {

    private final Connector connector;

    public UpdateHandler(@Lazy Connector botService) {
        this.connector = botService;
    }

    public void handle(Update update) {
        if (hasValidMessage(update)) {
            String text = fetchText(update);
            Long chatId = fetchChatId(update);

            if ("ping".equalsIgnoreCase(text)) {
                processPong(chatId);
            }
        }
    }

    private void processPong(Long chatId) {
        var msg = new SendMessage(chatId.toString(), "pong");
        connector.send(msg);
    }

    private static Long fetchChatId(Update update) {
        return update.getMessage().getChatId();
    }

    private static String fetchText(Update update) {
        return update.getMessage().getText().trim();
    }

    private static boolean hasValidMessage(Update update) {
        return update.hasMessage() && update.getMessage().hasText();
    }
}

