public class Panel implements UIComponent {
    private final String name;
    private final List<UIComponent> children = new ArrayList<>();

    public Panel(String name) { this.name = name; }
    public void add(UIComponent component) { children.add(component); }
    public void remove(UIComponent component) { children.remove(component); }

    @Override
    public void render() {
        System.out.println("--- Painel '" + name + "' ---");
        for (UIComponent child : children) {
            child.render();
        }
        System.out.println("--- Fim do Painel '" + name + "' ---");
    }
}