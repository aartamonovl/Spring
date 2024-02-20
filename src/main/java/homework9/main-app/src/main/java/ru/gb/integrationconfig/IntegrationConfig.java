package ru.gb.integrationconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.GenericTransformer;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.messaging.MessageChannel;
import ru.gb.models.Task;

import java.io.File;

@Configuration
public class IntegrationConfig {
    /**
     * Вход
     *
     * @return канал
     */
    @Bean
    public MessageChannel textInputChanel() {
        return new DirectChannel();
    }

    /**
     * Выход
     *
     * @return канал
     */
    @Bean
    public MessageChannel fileWriterChanel() {
        return new DirectChannel();
    }

    /**
     * Преобразование
     *
     * @return строка
     */
    @Bean
    @Transformer(inputChannel = "textInputChanel", outputChannel = "fileWriterChanel")
    public GenericTransformer<Task, String> mainTransformer() {
        return task -> {
            return "id: " + task.getId() + "\n" +
                    "description: " + task.getDescription() + "\n" +
                    "status: " + task.getStatus() + "\n" +
                    "creation date: " + task.getCreationDate() + "\n";
        };
    }

    /**
     * Запись строки в файл
     *
     * @return
     */
    @Bean
    @ServiceActivator(inputChannel = "fileWriterChanel")
    public FileWritingMessageHandler messageHandler() {
        FileWritingMessageHandler handler = new FileWritingMessageHandler(new File("./log"));
        handler.setExpectReply(false);
        handler.setFileExistsMode(FileExistsMode.APPEND);
        handler.setAppendNewLine(true);

        return handler;
    }
}
