public class ImmediateResponseStrategy implements ResponseStrategy {
    
    @Override
    public void execute(Command command) {
        String result = command.execute();
        System.out.println(LocalDateTime.now() + " Estratégia Imediata: " + result);
    }
}