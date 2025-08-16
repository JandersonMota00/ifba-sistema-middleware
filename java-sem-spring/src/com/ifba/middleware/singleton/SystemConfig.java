package com.ifba.middleware.singleton;

import java.time.LocalDateTime;

public class SystemConfig {
    
    private static SystemConfig instance;
    private String loggingPath = "logs/default_log.csv";
    private String themeMode = "light";

    private SystemConfig() { }

    public static SystemConfig getInstance() {
        if (instance == null) {
            instance = new SystemConfig();
        }
        return instance;
    }

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
