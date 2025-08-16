public class DarkThemeDecorator implements ThemedComponent {

    private final UIComponent component;

    public DarkThemeDecorator(UIComponent component) {
        this.component = component;
    }

    @Override
    public void render() {
        System.out.println("Aplicando Tema Escuro...");
        component.render();
        System.out.println("Tema Escuro aplicado.");
    }

    @Override
    public UIComponent getWrappedComponent() {
        return component;
    }
}