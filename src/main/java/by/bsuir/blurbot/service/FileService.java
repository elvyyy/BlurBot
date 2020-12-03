package by.bsuir.blurbot.service;

import by.bsuir.blurbot.core.BlurBot;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.methods.GetFile;
import org.telegram.telegrambots.meta.api.objects.File;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Objects;

@Slf4j
public class FileService {
    private static final FileService INSTANCE = new FileService();

    private FileService() {
    }

    public static FileService getInstance() {
        return INSTANCE;
    }

    public String getFilePath(PhotoSize photo) {
        Objects.requireNonNull(photo);

        String filepath = null;
        if (photo.hasFilePath()) {
            filepath =  photo.getFilePath();
        } else {
            GetFile getFileMethod = new GetFile();
            getFileMethod.setFileId(photo.getFileId());
            try {
                File file = BlurBot.getInstance().execute(getFileMethod);
                filepath =  file.getFilePath();
            } catch (TelegramApiException e) {
                log.error("Cannot fetch the filepath", e);
                e.printStackTrace();
            }
        }
        return filepath;
    }

    public java.io.File getPhoto(PhotoSize photoSize) throws TelegramApiException {
        return BlurBot.getInstance().downloadFile(getFilePath(photoSize));
    }
}
