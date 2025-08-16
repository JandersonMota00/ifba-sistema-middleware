package com.ifba.middleware.simulation;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import com.ifba.middleware.command.Command;
import com.ifba.middleware.command.FanOnCommand;
import com.ifba.middleware.composite.Button;
import com.ifba.middleware.composite.Panel;
import com.ifba.middleware.composite.Text;
import com.ifba.middleware.composite.UIComponent;
import com.ifba.middleware.decorator.DarkThemeDecorator;
import com.ifba.middleware.decorator.LightThemeDecorator;
import com.ifba.middleware.device.Device;
import com.ifba.middleware.device.Sensor;
import com.ifba.middleware.factory.DeviceFactory;
import com.ifba.middleware.observer.DeviceEvent;
import com.ifba.middleware.strategy.ImmediateResponseStrategy;
import com.ifba.middleware.strategy.ResponseStrategy;
import com.ifba.middleware.config.SystemConfig;
import com.ifba.middleware.factory.DefaultDeviceFactory;
import com.ifba.middleware.logger.Logger;
import com.ifba.middleware.strategy.DelayedResponseStrategy;
import com.ifba.middleware.singleton.SystemConfig;

@Service
public class SimulationService {
    
    private final DeviceFactory deviceFactory;
    private final Map<String, Device> devices = new HashMap<>();
    private final ApplicationEventPublisher eventPublisher;
    private final SystemConfig systemConfig;
    private final Logger logger;
    private final ResponseStrategy immediateResponseStrategy;

    public SimulationService(DeviceFactory deviceFactory, ApplicationEventPublisher eventPublisher,
                             SystemConfig systemConfig, Logger logger,
                             ImmediateResponseStrategy immediateResponseStrategy) {
        this.deviceFactory = deviceFactory;
        this.eventPublisher = eventPublisher;
        this.systemConfig = systemConfig;
        this.logger = logger;
        this.immediateResponseStrategy = immediateResponseStrategy;
    }

    @PostConstruct
    public void setupSimulation() {
        devices.put("light_quarto", deviceFactory.createDevice("light", "luz_quarto", "off"));
        devices.put("fan_sala", deviceFactory.createDevice("fan", "ventilador_sala", "off"));
        devices.put("sensor_temperatura_sala", deviceFactory.createDevice("sensor", "sensor_temperatura_sala", 25));
    }

    @Scheduled(fixedRate = 10000) // Simula a cada 10 segundos
    public void runSimulation() {
        System.out.println("\n--- Simulação em execução ---");

        // Simula a leitura do sensor
        Sensor sensor = (Sensor) devices.get("sensor_temperatura_sala");
        int currentTemp = sensor.readValue();
        System.out.println(LocalDateTime.now() + " Simulação: Sensor de temperatura lendo " + currentTemp + "°C");

        // Regra de evento: se a temperatura for maior que 28°C
        if (currentTemp > 28 && devices.get("fan_sala").getState().equals("off")) {
            System.out.println(LocalDateTime.now() + " Evento detectado: Temperatura acima de 28°C.");
            // Publica o evento para que os observadores reajam
            eventPublisher.publishEvent(new DeviceEvent(this, "TEMPERATURE_HIGH",
                    Map.of("deviceId", sensor.getDeviceId(), "value", currentTemp)));

            // Executa o comando para ligar o ventilador usando a estratégia
            Command turnOnFanCommand = new FanOnCommand(devices.get("fan_sala"));
            immediateResponseStrategy.execute(turnOnFanCommand);
        }

        // Loga o evento
        logger.logEvent("SENSOR_READING", "{\"device_id\": \"" + sensor.getDeviceId() + "\", \"value\": " + currentTemp + "}");
        
        // Exibe o status dos dispositivos e a UI simulada
        System.out.println("--- Estado Atual dos Dispositivos ---");
        devices.values().forEach(System.out::println);
        
        displayUI(systemConfig.getThemeMode());
        
        // Simula o aumento da temperatura para a próxima leitura
        sensor.updateValue(currentTemp + 1);
        systemConfig.setThemeMode(systemConfig.getThemeMode().equals("light") ? "dark" : "light");
    }

    private void displayUI(String themeMode) {
        System.out.println("\n--- Interface do Middleware ---");
        Panel mainPanel = new Panel("MainPanel");
        mainPanel.add(new Text("Smart Home Control"));
        mainPanel.add(new Button("Fan Control"));
        mainPanel.add(new Button("Light Control"));

        UIComponent themedUI;
        if ("dark".equals(themeMode)) {
            themedUI = new DarkThemeDecorator(mainPanel);
        } else {
            themedUI = new LightThemeDecorator(mainPanel);
        }
        themedUI.render();
        System.out.println("---------------------------------");
    }
}
