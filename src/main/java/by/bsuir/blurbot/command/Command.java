package by.bsuir.blurbot.command;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.User;

public interface Command {
    void execute(User user, String arg, SendMessage response);
}
