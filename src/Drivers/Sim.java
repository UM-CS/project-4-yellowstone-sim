package Drivers;

import Animals.*;
import Environment.Environment;
import Environment.Position;
import Environment.SpaceCheck;
import Organisms.Organism;
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


    private final int INITIAL_ELK =10;
    private final int INITIAL_GRASS =50;
    private final int INITIAL_WOLVES =10;


    private void spawnInitial() {
            //for (int i = 0; i < INITIAL_GRASS;  i++) organisms.add(new Grass(e,10));
            //for (int i = 0; i < INITIAL_ELK;    i++) organisms.add(new elk(e, 1000, randomPosition(), 100, 1, 1, 1,"ELK".concat(String.valueOf(i))));
            //for (int i = 0; i < INITIAL_WOLVES; i++) organisms.add(new wolf(e, 1000, randomPosition(), 100, 1,1 ,1,"WOLF".concat(String.valueOf(i))));

            organisms.add(new elk(this,"Weakling ELK",e,new Position(1,1),100,100,10,10,2,Color.GREEN));
            organisms.add(new elk(this,"Weakling ELK",e,new Position(1,1),100,100,10,10,2,Color.GREEN));

        }

    private Position randomPosition() {
        Random rand = new Random();
        int x = rand.nextInt(gridSize);
        int y = rand.nextInt(gridSize);
        return new Position(x, y);
    }    


    // public void go()
    // {
    //     spawnInitial();
    //     System.out.println("we have " + organisms.size() + " Organisms\n");
    //     System.out.println(organisms.get(0).toString());
    //     organisms.get(0).act();
    //     System.out.println(organisms.get(0).toString());
    // }

    @Override
    public List<Organism> getOrganismsWithinRange(Organism source, double range) {
        List<Organism> thingsNear =new ArrayList<>();
        Position OrgPos=source.getPosition();

            for (Organism o : organisms) {
                if (o != source && o.isAlive()) 
                {
                    if (OrgPos.distaceTo(o.getPosition()) <= range) thingsNear.add(o);
                }
                
            }
            return thingsNear;

    }

    public int getGridSize()
    {
        return gridSize;
    }



    public Sim(int n) {
    setBackground(new Color(20, 20, 30));

    organisms = new ArrayList<>();

    for (int i = 0; i < n; i++) {
        organisms.add(new elk(this,"ELK_" + i,e,randomPosition(),100,100,10,10,2,Color.GREEN));
    }

    new Timer(200, e -> {
        for (Organism o : organisms) {
            if (o.isAlive()) {

                //commented out for testing purposes
                //o.change();
                o.act();
            }
        }
        organisms.removeIf(o -> !o.isAlive());
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