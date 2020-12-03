package by.bsuir.blurbot.context.impl;

import by.bsuir.blurbot.context.ApplicationContext;
import by.bsuir.blurbot.core.BlurBot;
import by.bsuir.blurbot.domain.BotUser;
import by.bsuir.blurbot.util.PropertyReaderUtil;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

@Slf4j
public class BotContext implements ApplicationContext {

    private static final BotContext INSTANCE = new BotContext();
    private Collection<BotUser> users = new HashSet<>();

    private BotContext() {
    }

    public static BotContext getInstance() {
        return INSTANCE;
    }

    @Override
    public void init() {
        ApiContextInitializer.init();
        TelegramBotsApi botsApi = new TelegramBotsApi();
        try {
            PropertyReaderUtil.loadProperties();
            BlurBot blurBot = BlurBot.getInstance();
            botsApi.registerBot(blurBot);
        } catch (TelegramApiException e) {
            log.error("Cannot instantiate the bot", e);
        } catch (IOException e) {
            log.error("Cannot read the property file", e);
        }
    }

    @Override
    public <T> Collection<T> retrieveEntityList(Class<T> clazz) {
        if (clazz == BotUser.class) {
            return (Collection<T>) users;
        }
        return null;
    }

}
