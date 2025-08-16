package com.ifba.middleware.strategy;

import com.ifba.middleware.command.Command;

public interface ResponseStrategy {

    void execute(Command command);

}
