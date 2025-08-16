package com.ifba.middleware.composite;

import com.ifba.middleware.decorator.UIComponent;

public class Button implements UIComponent {

    private final String label;

    public Button(String label) {
        this.label = label;
    }

    @Override
    public void render() {
        System.out.println("[ Botão: " + label + " ]");
    }
}