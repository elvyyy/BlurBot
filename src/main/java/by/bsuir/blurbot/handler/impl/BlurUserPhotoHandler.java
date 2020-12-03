package by.bsuir.blurbot.handler.impl;

import by.bsuir.blurbot.core.BlurBot;
import by.bsuir.blurbot.handler.Handler;
import by.bsuir.blurbot.service.BlurService;
import by.bsuir.blurbot.service.FileService;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.util.List;

public class BlurUserPhotoHandler implements Handler {
    @Override
    public void handle(Update update) throws TelegramApiException {
        List<PhotoSize> photo = update.getMessage().getPhoto();
        PhotoSize photoSize = photo.get(photo.size() - 1);
        File downloadedPhoto = FileService.getInstance().getPhoto(photoSize);
        File blurredImg = BlurService.getInstance().blurFaces(downloadedPhoto);
        SendPhoto sendPhoto = new SendPhoto()
                .setPhoto(blurredImg)
                .setChatId(update.getMessage().getChatId());

        BlurBot.getInstance().execute(sendPhoto);
    }
}
