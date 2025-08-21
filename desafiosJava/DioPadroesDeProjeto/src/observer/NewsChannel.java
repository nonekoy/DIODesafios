package observer;

/**
 * Implementação concreta de Observer - Canal de Notícias
 */
public class NewsChannel implements Observer {
    
    private String channelName;
    private String channelType;
    
    public NewsChannel(String channelName, String channelType) {
        this.channelName = channelName;
        this.channelType = channelType;
        System.out.println("📺 Canal '" + channelName + "' (" + channelType + ") criado!");
    }
    
    @Override
    public void update(String state) {
        System.out.println("📺 CANAL: " + channelName + " (" + channelType + ")");
        System.out.println("📡 Recebeu notícia: " + state);
        System.out.println("🎬 Transmitindo ao vivo...");
        System.out.println("✅ Notícia transmitida com sucesso!");
    }
    
    @Override
    public String getName() {
        return channelName + " (" + channelType + ")";
    }
    
    public String getChannelName() {
        return channelName;
    }
    
    public String getChannelType() {
        return channelType;
    }
}
