public class Main {
    public static void main(String[] args) {
        // --- Injeção de Dependência Manual (simulando o Spring) ---
        // Instâncias Singleton
        SystemConfig systemConfig = SystemConfig.getInstance();
        Logger logger = Logger.getInstance();
        
        // Instâncias de Fábrica e Estratégia
        DeviceFactory deviceFactory = new DefaultDeviceFactory();
        ResponseStrategy immediateResponseStrategy = new ImmediateResponseStrategy();

        // Configuração do Publisher de Eventos
        EventPublisher eventPublisher = new EventPublisher();
        eventPublisher.addListener(new DeviceEventListener());

        // Inicia o serviço de simulação com todas as dependências
        SimulationService simulationService = new SimulationService(
            deviceFactory,
            eventPublisher,
            systemConfig,
            logger,
            immediateResponseStrategy
        );

        // Agendador de tarefas para rodar a simulação a cada 10 segundos
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                simulationService.runSimulation();
            }
        }, 0, 10000);
    }
}