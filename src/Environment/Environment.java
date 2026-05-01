package Environment;

import java.awt.Color;

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
            case "FALL": return .7;
            case "WINTER": return 1.5;
            case "SPRING": return .7;
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
            case "SUMMER": return .7;
            case "FALL": return 0.3;
            case "WINTER": return .05;
            case "SPRING": return .9;
            default: return 0;
        }
    }


        public double getDeathChange()
    {
        switch(season) {
            case "SUMMER": return .05;
            case "FALL": return 0.2;
            case "WINTER": return .6;
            case "SPRING": return .02;
            default: return 0;
        }
    }

    public Color getColor()
    {
        switch (season == null ? "" : season.toLowerCase()) {
            case "spring":
                return Color.GREEN;
            case "summer":
                return new Color(34, 139, 34);
                
            case "fall":
                return new Color(210, 105, 30);
            case "winter":
                return Color.LIGHT_GRAY;
            default:
                return Color.GREEN;
                
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
