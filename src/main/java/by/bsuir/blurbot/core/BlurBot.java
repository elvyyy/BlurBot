package by.bsuir.blurbot.core;

import by.bsuir.blurbot.domain.ApplicationProperties;
import by.bsuir.blurbot.handler.impl.UserInputHandler;
import by.bsuir.blurbot.service.BlurService;
import by.bsuir.blurbot.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ActionType;
import org.telegram.telegrambots.meta.api.methods.send.SendChatAction;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;
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
//        executorService.submit(() -> {
//            try {
//                new UserInputHandler()
//                        .handle(update);
//            } catch (TelegramApiException e) {
//                log.error("Cannot process the update", e);
//            }
//        });

        try {
            new UserInputHandler()
                    .handle(update);
        } catch (TelegramApiException e) {
            log.error("Cannot process the update", e);
        }

//        try {
//            new UserInputHandler()
//                    .handle(update);
//        } catch (TelegramApiException e) {
//            log.error("Cannot process the update", e);
//        }

//        List<PhotoSize> photos = update.getMessage().getPhoto();
//        if (photos == null) {
//            return;
//        }
//        SendChatAction sendChatAction = new SendChatAction();
//        sendChatAction.setAction(ActionType.UPLOADPHOTO);
//        sendChatAction.setChatId(update.getMessage().getChatId());
//        try {
//            execute(sendChatAction);
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
//
//        PhotoSize photo = photos.get(photos.size() - 1);
//
//        java.io.File file = null;
//        try {
//            String filepath = FileService.getInstance().getFilePath(photo);
//            file = downloadFile(filepath);
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }
//
//        java.io.File blurredFile = BlurService.getInstance().blurFaces(file);
//        SendPhoto sendPhoto = new SendPhoto();
//        sendPhoto.setPhoto(blurredFile);
//        sendPhoto.setChatId(update.getMessage().getChatId());
//
//        try {
//            execute(sendPhoto);
//        } catch (TelegramApiException e) {
//            e.printStackTrace();
//        }

    }



}
