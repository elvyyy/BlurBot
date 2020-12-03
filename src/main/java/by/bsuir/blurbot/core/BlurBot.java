package by.bsuir.blurbot.core;

import by.bsuir.blurbot.domain.ApplicationProperties;
import by.bsuir.blurbot.handler.impl.UserInputHandler;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class BlurBot extends TelegramLongPollingBot {

    private static final BlurBot INSTANCE = new BlurBot();

    private final ExecutorService executorService = Executors.newFixedThreadPool(8);

    private String botToken;

    private String botUsername;

    public static BlurBot getInstance() {
        return INSTANCE;
    }

    private BlurBot() {
        botUsername = ApplicationProperties.getInstance().getBotUsername();
        botToken = ApplicationProperties.getInstance().getBotToken();
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public void onUpdateReceived(Update update) {
        executorService.submit(() -> {
            try {
                new UserInputHandler()
                        .handle(update);
            } catch (TelegramApiException e) {
                log.error("Cannot process the update", e);
            }
        });
    }
}
