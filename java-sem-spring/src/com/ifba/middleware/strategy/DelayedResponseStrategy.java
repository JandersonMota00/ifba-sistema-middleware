public class DelayedResponseStrategy implements ResponseStrategy {
    
    @Override
    public void execute(Command command) {
        System.out.println(LocalDateTime.now() + " Estratégia Atrasada: Aguardando 5 segundos...");
        try {
            Thread.sleep(5000); // Simula um atraso
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        String result = command.execute();
        System.out.println(LocalDateTime.now() + " Estratégia Atrasada: " + result);
    }
}