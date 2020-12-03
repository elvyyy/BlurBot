package by.bsuir.blurbot.handler.impl;

import by.bsuir.blurbot.command.Command;
import by.bsuir.blurbot.command.impl.StartCommand;
import by.bsuir.blurbot.core.BlurBot;
import by.bsuir.blurbot.handler.Handler;
import by.bsuir.blurbot.service.BlurService;
import by.bsuir.blurbot.service.FileService;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class UserInputHandler implements Handler {

    @Override
    public void handle(Update update) throws TelegramApiException {
        Message msg = update.getMessage();

        Handler userInputHandler;
        Command command;

        if (msg.getPhoto() != null) {
            userInputHandler = new BlurUserPhotoHandler();
            userInputHandler.handle(update);
        } else if (msg.getText() != null && msg.getText().startsWith("/start")) {
            command = new StartCommand();
            SendMessage response = new SendMessage();
            response.setChatId(update.getMessage().getChatId());
            command.execute(update.getMessage().getFrom(), null, response);
            BlurBot.getInstance().execute(response);
        }
    }

}
