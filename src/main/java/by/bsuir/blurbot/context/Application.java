package by.bsuir.blurbot.context;

import by.bsuir.blurbot.context.impl.BotContext;
import org.opencv.core.Core;

import java.util.function.Supplier;

public interface Application {
    static ApplicationMenu start() {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        final Supplier<ApplicationContext> applicationContextSupplier = BotContext::getInstance;
        BotContext botContext = BotContext.getInstance();

        botContext.init();
        return applicationContextSupplier::get;
    }
}
