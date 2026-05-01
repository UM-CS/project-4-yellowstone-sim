package Drivers;
import Animals.*;
import Environment.Environment;
import Environment.Position;
import Environment.SpaceCheck;
import Organisms.*;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Sim extends JPanel implements SpaceCheck {

    private final int gridSize=50;
    private final int CELL_SIZE = 15;
    private List<Organism> organisms = new ArrayList<>();
    private int tickCount = 0;
    protected Environment environment= new Environment();
    public List<Organism> babieList = new ArrayList<>();

    private Color elkColor = new Color(150,75,0);


    private final int INITIAL_ELK =10;
    private final int INITIAL_GRASS =100;
    private final int INITIAL_WOLVES =2;


    private void spawnInitial() {
            for (int i = 0; i < INITIAL_GRASS;  i++) organisms.add(new Grass(this, "grass", environment, randomPosition(), CELL_SIZE));
            for (int i = 0; i < INITIAL_ELK;    i++) organisms.add(new elk(this,"elk",environment,randomPosition(),100,100,10,0,10,elkColor));
            for (int i = 0; i < INITIAL_WOLVES; i++) organisms.add(new wolf(this, "wolf", environment,randomPosition(), 100,100,10,0,10,Color.YELLOW));

          

        }

    private Position randomPosition() {
        Random rand = new Random();
        int x = rand.nextInt(60);
        int y = rand.nextInt(45);
        return new Position(x, y);
    }    



    public int organismsCount()
    {
        return organisms.size();
    }

    public void takeBabies(Organism x)
    {
        babieList.add(x);
    }

    public void addBabies()
    {
        for(Organism x: babieList)
            organisms.add(x);
        babieList.clear();
    }

    @Override
     public <x> List<x> getOrganismsWithinRange(Organism source, int range, Class<?> x) {
        List<x> thingsNear =new ArrayList<>();
        Position OrgPos=source.getPosition();

            for (Organism o : organisms) {
                if (o != source && o.isAlive() && o.getClass()==x) 
                {
                    if (OrgPos.distaceTo(o.getPosition()) <= range) thingsNear.add((x) o);
                }
                
            }

            thingsNear.sort(java.util.Comparator.comparingDouble(o -> OrgPos.distaceTo(((Organism)o).getPosition())));
            
            return thingsNear;
        

    }

    public int getGridSize()
    {
        return gridSize;
    }

    public int getTick()
    {
        return tickCount;
    }



    public void go(int n) {
    setBackground(new Color(20, 20, 30));

    spawnInitial();    

    new Timer(750, e -> {
        tickCount+=1;
        for (Organism o : organisms) {
            if (o.isAlive()) {

                //commented out for testing purposes
                o.change();
               o.act();
                //System.out.println(o.toString());
            }
        }
        organisms.removeIf(o -> !o.isAlive());
        if(tickCount%10==0)
        {
            System.out.println(environment.getSeason());
            environment.changeSeason();

        }
        addBabies();
        repaint();
        System.out.print(getTick());
    }).start();
}

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Organism a : organisms) a.draw(g);
        }
}