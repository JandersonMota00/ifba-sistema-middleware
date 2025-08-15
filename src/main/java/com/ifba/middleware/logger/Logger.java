package com.ifba.middleware.logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class Logger {
    private PrintWriter writer;

    @PostConstruct
    public void init() {
        try {
            // Em um projeto real, você criaria a pasta 'logs' antes.
            writer = new PrintWriter(new FileWriter("system_log.csv", true));
            writer.println("timestamp,log_type,data");
        } catch (IOException e) {
            System.err.println("Erro ao inicializar o logger: " + e.getMessage());
        }
    }

    public void logEvent(String logType, String data) {
        writer.println(LocalDateTime.now() + "," + logType + "," + data);
        writer.flush();
    }
}