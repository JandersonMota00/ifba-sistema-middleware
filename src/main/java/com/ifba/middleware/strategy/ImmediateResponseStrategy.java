package com.ifba.middleware.strategy;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.ifba.middleware.command.Command;

@Component("immediateResponseStrategy")
public class ImmediateResponseStrategy implements ResponseStrategy {
    @Override
    public void execute(Command command) {
        String result = command.execute();
        System.out.println(LocalDateTime.now() + " Estratégia Imediata: " + result);
    }
}