public class Logger {

    private static Logger instance;
    private PrintWriter writer;

    private Logger() {
        try {
            writer = new PrintWriter(new FileWriter("system_log.csv", true));
            writer.println("timestamp,log_type,data");
        } catch (IOException e) {
            System.err.println("Erro ao inicializar o logger: " + e.getMessage());
        }
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
    
    public void logEvent(String logType, String data) {
        String timestamp = LocalDateTime.now().toString();
        writer.println(timestamp + "," + logType + "," + data);
        writer.flush();
    }
    
}
