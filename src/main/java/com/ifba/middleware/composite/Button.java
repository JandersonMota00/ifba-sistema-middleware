package com.ifba.middleware.composite;

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