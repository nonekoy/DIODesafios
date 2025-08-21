package observer;

/**
 * Implementação concreta de Subject - Agência de Notícias
 */
public class NewsAgency extends Subject {
    
    private String agencyName;
    
    public NewsAgency(String agencyName) {
        this.agencyName = agencyName;
        System.out.println("📰 Agência de Notícias '" + agencyName + "' criada!");
    }
    
    /**
     * Publica uma nova notícia
     */
    public void publishNews(String news) {
        System.out.println("\n📰 AGÊNCIA DE NOTÍCIAS: " + agencyName);
        System.out.println("================================");
        setState("BREAKING NEWS: " + news);
        System.out.println("================================");
    }
    
    /**
     * Publica uma notícia de esporte
     */
    public void publishSportsNews(String sportsNews) {
        System.out.println("\n⚽ AGÊNCIA DE NOTÍCIAS: " + agencyName);
        System.out.println("================================");
        setState("ESPORTES: " + sportsNews);
        System.out.println("================================");
    }
    
    /**
     * Publica uma notícia de tecnologia
     */
    public void publishTechNews(String techNews) {
        System.out.println("\n💻 AGÊNCIA DE NOTÍCIAS: " + agencyName);
        System.out.println("================================");
        setState("TECNOLOGIA: " + techNews);
        System.out.println("================================");
    }
    
    public String getAgencyName() {
        return agencyName;
    }
}
