package by.bsuir.blurbot.domain;

import lombok.Data;


@Data
public class ApplicationProperties {

    private static final ApplicationProperties INSTANCE = new ApplicationProperties();

    private String botUsername;

    private String botToken;

    private String cmlFile;

    private int threadPoolSize;

    private ApplicationProperties() {
    }

    public static ApplicationProperties getInstance() {
        return INSTANCE;
    }
}
