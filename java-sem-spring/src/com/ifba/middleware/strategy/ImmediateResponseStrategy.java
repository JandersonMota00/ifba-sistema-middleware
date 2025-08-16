package com.ifba.middleware.strategy;

import java.time.LocalDateTime;
import com.ifba.middleware.command.Command;
import com.ifba.middleware.strategy.ResponseStrategy;

public class ImmediateResponseStrategy implements ResponseStrategy {
    
    @Override
    public void execute(Command command) {
        String result = command.execute();
        System.out.println(LocalDateTime.now() + " Estratégia Imediata: " + result);
    }
}