package by.bsuir.blurbot.util;

import by.bsuir.blurbot.domain.ApplicationProperties;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Slf4j
public class PropertyReaderUtil {

    private PropertyReaderUtil() {
    }

    /**
     * try-with-resource using FileInputStream.
     *
     * <p>
     * as a result - populates {@link ApplicationProperties} with corresponding
     * values from the property file
     */
    public static void loadProperties() throws IOException {
        final String propertiesFileName = "application.properties";
        String filePath = "src/main/resources/" + propertiesFileName;
        log.info("Loading properties {}", filePath);

        Properties properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream(filePath)) {
            properties.load(inputStream);
        } finally {
            populateProperties(properties);
            log.info("Properties are loaded successfully");
        }
    }

    private static void populateProperties(Properties properties) {
        ApplicationProperties applicationProperties = ApplicationProperties.getInstance();
        applicationProperties.setBotToken(properties.getProperty("token", ""));
        applicationProperties.setBotUsername(properties.getProperty("name", ""));
        applicationProperties.setCmlFile(properties.getProperty("cmlFile", ""));
    }
}
