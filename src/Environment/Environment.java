package Environment;

public class Environment {
    
    private String[] Seasons={"SPRING","SUMMER","FALL","WINTER"};

    private String season;
    private int tempature; 
    private int tickDay;

    //create a system where theses vary tick to tick but will be constant for now
    private final int SPRINGTEMP=40;
    private final int SUMMERTEMP=70;
    private final int FALLTEMP=40;
    private final int WINTERTEMP=20;


    public double getHungerMultiplier()
    {
        switch(season) {
            case "SUMMER": return .7;
            case "FALL": return 1.0;
            case "WINTER": return 1.5;
            case "SPRING": return 1.0;
            default: return 1.0;
        }
    }

    public Environment()
    {
        season =Seasons[0];
        tempature=SPRINGTEMP;
        tickDay=0;
    }

    public void changeSeason()
    {
        int currentIndex = java.util.Arrays.asList(Seasons).indexOf(season);
        currentIndex = (currentIndex + 1) % 4;
        season = Seasons[currentIndex];
    }
    
    //TODO changes how likley a plant is to grow
    public double getGrowthChange()
    {
        switch(season) {
            case "SUMMER": return 1.2;
            case "FALL": return 0.8;
            case "WINTER": return 0.4;
            case "SPRING": return 2.0;
            default: return 0;
        }
    }



        public double getTemp()
    {
        switch(season) {
            case "SUMMER": return 1.2;
            case "FALL": return 1.0;
            case "WINTER": return 0.2;
            case "SPRING": return 1.5;
            default: return 1.0;
        }
    }


    public String getSeason()
    {
        return season;
    }

}
