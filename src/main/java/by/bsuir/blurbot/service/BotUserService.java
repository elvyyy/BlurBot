package by.bsuir.blurbot.service;

import by.bsuir.blurbot.context.impl.BotContext;
import by.bsuir.blurbot.domain.BotUser;
import org.telegram.telegrambots.meta.api.objects.User;

import java.util.Optional;

public class BotUserService {

    private static final BotUserService INSTANCE = new BotUserService();

    public static BotUserService getInstance() {
        return INSTANCE;
    }

    private BotUserService() {
    }

    public boolean addUser(BotUser user) {
        return BotContext.getInstance()
                .retrieveEntityList(BotUser.class)
                .add(user);

    }

    public Optional<BotUser> findUser(Integer id) {
        return BotContext.getInstance()
                .retrieveEntityList(BotUser.class)
                .stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

}
