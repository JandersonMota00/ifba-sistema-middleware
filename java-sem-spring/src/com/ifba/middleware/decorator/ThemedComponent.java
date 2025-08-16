package com.ifba.middleware.decorator;

import com.ifba.middleware.decorator.UIComponent;

public interface ThemedComponent extends UIComponent {
    UIComponent getWrappedComponent();
}