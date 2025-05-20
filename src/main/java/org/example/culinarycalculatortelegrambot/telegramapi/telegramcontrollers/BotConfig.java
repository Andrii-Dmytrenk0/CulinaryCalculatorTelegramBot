package org.example.culinarycalculatortelegrambot.telegramapi.telegramcontrollers;

import org.example.culinarycalculatortelegrambot.telegramapi.telegramcontrollers.CommunicationWithTelegramBot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
public class BotConfig {

    @Bean
    public TelegramBotsApi telegramBotsApi(CommunicationWithTelegramBot bot) throws TelegramApiException {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(bot); // Регистрация бота вручную
        return botsApi;
    }
}
