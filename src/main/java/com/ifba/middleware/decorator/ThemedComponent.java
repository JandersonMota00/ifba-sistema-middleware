package com.ifba.middleware.decorator;

import com.ifba.middleware.composite.UIComponent;

public interface ThemedComponent extends UIComponent {
    UIComponent getWrappedComponent();
}