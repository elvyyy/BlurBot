package by.bsuir.blurbot.context;

import org.telegram.telegrambots.meta.api.objects.User;

import java.util.Collection;

public interface ApplicationContext {
    void init();

    <T> Collection<T> retrieveEntityList(Class<T> clazz);
}
