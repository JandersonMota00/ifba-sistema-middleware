public class Text implements UIComponent {

    private final String content;

    public Text(String content) {
        this.content = content;
    }

    @Override
    public void render() {
        System.out.println("Texto: " + content);
    }
}