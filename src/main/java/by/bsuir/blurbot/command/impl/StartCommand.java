package by.bsuir.blurbot.command.impl;

import by.bsuir.blurbot.command.Command;
import by.bsuir.blurbot.domain.BotUser;
import by.bsuir.blurbot.service.BotUserService;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.User;

import java.util.Optional;
import java.util.StringJoiner;

public class StartCommand implements Command {

    @Override
    public void execute(User user, String arg, SendMessage response) {
        BotUserService userService = BotUserService.getInstance();
        BotUser botUser = userService.findUser(user.getId())
            .orElseGet(() -> {
                BotUser newUser = BotUser.builder()
                        .firstName(user.getFirstName())
                        .id(user.getId())
                        .build();

                userService.addUser(newUser);
                return newUser;
            });

        String resp = new StringJoiner(" ")
                .add("Привет")
                .add(botUser.getFirstName() + "!")
                .add("\nВведи /help и узнаешь все доступное.")
                .add("\nПросто отправь изображение!")
                .toString();
        response.setText(resp);
    }

}
