package com.ifba.middleware.decorator;

import com.ifba.middleware.decorator.UIComponent;
import com.ifba.middleware.decorator.ThemedComponent;
import com.ifba.middleware.decorator.DarkThemeDecorator;
import com.ifba.middleware.decorator.LightThemeDecorator;

public class LightThemeDecorator implements ThemedComponent {

    private final UIComponent component;

    public LightThemeDecorator(UIComponent component) {
        this.component = component;
    }

    @Override
    public void render() {
        System.out.println("Aplicando Tema Claro...");
        component.render();
        System.out.println("Tema Claro aplicado.");
    }

    @Override
    public UIComponent getWrappedComponent() {
        return component;
    }
}