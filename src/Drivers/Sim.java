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
    Environment e= new Environment();
    private final int seasonLength=75;
    public List<Organism> babieList = new ArrayList<>();


    private final int INITIAL_ELK =10;
    private final int INITIAL_GRASS =50;
    private final int INITIAL_WOLVES =10;


    private void spawnInitial() {
            //for (int i = 0; i < INITIAL_GRASS;  i++) organisms.add(new Grass(e,10));
            //for (int i = 0; i < INITIAL_ELK;    i++) organisms.add(new elk(e, 1000, randomPosition(), 100, 1, 1, 1,"ELK".concat(String.valueOf(i))));
            //for (int i = 0; i < INITIAL_WOLVES; i++) organisms.add(new wolf(e, 1000, randomPosition(), 100, 1,1 ,1,"WOLF".concat(String.valueOf(i))));

            organisms.add(new elk(this,"Strong ELK",e,new Position(1,1),100,50,10,10,10,Color.YELLOW));
            organisms.add(new elk(this,"Weakling ELK",e,new Position(60,45),100,100,10,10,10,Color.GREEN));

            organisms.add(new Grass(this, "grass", e, new Position(10,10), CELL_SIZE));
        
            organisms.add(new Grass(this, "grass", e, new Position(15,10), CELL_SIZE ));

        organisms.add(new Grass(this, "grass", e, new Position(20,10), CELL_SIZE));

        organisms.add(new Grass(this, "grass", e, new Position(25,10), CELL_SIZE));

        organisms.add(new Grass(this, "grass", e, new Position(30,10), CELL_SIZE));

        }

    private Position randomPosition() {
        Random rand = new Random();
        int x = rand.nextInt(gridSize);
        int y = rand.nextInt(gridSize);
        return new Position(x, y);
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
            return thingsNear;

    }

    public int getGridSize()
    {
        return gridSize;
    }



    public void go(int n) {
    setBackground(new Color(20, 20, 30));

    spawnInitial();    

    new Timer(500, e -> {
        for (Organism o : organisms) {
            if (o.isAlive()) {

                //commented out for testing purposes
                //o.change();
               o.act();
                System.out.println(o.toString());
            }
        }
        organisms.removeIf(o -> !o.isAlive());
        addBabies();
        repaint();
    }).start();
}

    //  //not used currently, ignore
    // private void generateMap() {
    //     for (int x = 0; x < gridSize; x++) {
    //         for (int y = 0; y < gridSize; y++) {
    //             //for terrain, or could be used for grass or something
                
    //         }
    //     }
    // }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Organism a : organisms) a.draw(g);
        }
}