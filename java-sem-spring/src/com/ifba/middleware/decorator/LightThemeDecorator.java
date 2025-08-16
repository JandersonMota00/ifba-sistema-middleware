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