package ru.gb.services;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;
import ru.gb.models.Task;

@MessagingGateway(defaultRequestChannel = "textInputChanel")
public interface FileGateway {
    void writeToFile(@Header(FileHeaders.FILENAME) String filename, Task task);
}
