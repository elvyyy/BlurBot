package by.bsuir.blurbot.context;

import java.util.Collection;

public interface ApplicationContext {
    void init();

    <T> Collection<T> retrieveEntityList(Class<T> clazz);
}
