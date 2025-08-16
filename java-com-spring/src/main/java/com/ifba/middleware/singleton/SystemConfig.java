package com.ifba.middleware.singleton;

import org.springframework.stereotype.Component;

@Component
public class SystemConfig {

    private String loggingPath = "logs/default_log.csv";
    private String themeMode = "light";

    public String getLoggingPath() {
        return loggingPath;
    }

    public void setLoggingPath(String loggingPath) {
        this.loggingPath = loggingPath;
    }

    public String getThemeMode() {
        return themeMode;
    }
    
    public void setThemeMode(String themeMode) {
        if ("light".equals(themeMode) || "dark".equals(themeMode)) {
            this.themeMode = themeMode;
        } else {
            System.out.println("Modo de tema inválido. Usando 'light' por padrão.");
            this.themeMode = "light";
        }
    }
}