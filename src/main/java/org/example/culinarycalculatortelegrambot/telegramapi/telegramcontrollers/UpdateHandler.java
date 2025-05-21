package org.example.culinarycalculatortelegrambot.telegramapi.telegramcontrollers;

import org.example.culinarycalculatortelegrambot.telegramapi.TelegramBotService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class UpdateHandler {

    private final TelegramBotService botService;

    public UpdateHandler(@Lazy TelegramBotService botService) {
        this.botService = botService;
    }

    public void handleUpdate(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String text = update.getMessage().getText().trim();
            Long chatId = update.getMessage().getChatId();
            System.out.println("Chat ID: " + chatId);

            if ("ping".equalsIgnoreCase(text)) {
                botService.sendMessageToChat(chatId, "pong");
            }
            // Можно добавить логику для других команд
        }
    }
}

