package Drivers;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Spliterator;

import Organisms.Grass;
import Organisms.Organism;
import Animals.*;
import Environment.Environment;
import Environment.Position;
import Environment.SpaceCheck;

public class Sim implements SpaceCheck {

private final int gridSize=100;
private List<Organism> organisms = new ArrayList<>();
public List<Organism> babieList = new ArrayList<>();
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

        organisms.add(new elk(this,"Weakling ELK",e,new Position(50,50),100,10,10,10,2));
        organisms.add(new elk(this,"Strong ELK",e,new Position(1,1),100,100,10,10,2));

        organisms.add(new Grass(this, "grass", e, new Position(0,0),100));
        organisms.add(new Grass(this, "grass2", e, new Position(1,1),100));

        organisms.add(new wolf(this, "Wolf", e, new Position(49,49), 100, 100, 10, 10, 10));
    }

private Position randomPosition() {
    Random rand = new Random();
    int x = rand.nextInt(gridSize);
    int y = rand.nextInt(gridSize);
    return new Position(x, y);
}    


public void go()
{
    spawnInitial();
    System.out.println("we have " + organisms.size() + " Organisms\n");

    for(Organism x : organisms)
        System.out.println(x.toString());

    organisms.get(0).act();
    organisms.get(1).act();
    
   addBabies();

    System.out.println("we have " + organisms.size() + " Organisms\n");

    for(Organism x : organisms)
        System.out.println(x.toString());
    
}

@Override
public <x> List<x> getOrganismsWithinRange(Organism source, int range, Class<?> x) {
    List<x> thingsNear = new ArrayList<>();
    Position OrgPos = source.getPosition();

          for (Organism o : organisms) {
            if (o != source && o.isAlive() &&o.getClass()==x) 
            {
                if (OrgPos.distaceTo(o.getPosition()) <= range) thingsNear.add((x) o);
                
            }
            
        }
        
        thingsNear.sort((a,b)-> Double.compare(OrgPos.distaceTo(((Organism) a).getPosition()), OrgPos.distaceTo(((Organism) b).getPosition())));

        return thingsNear;

}

public int getGridSize()
{
    return gridSize;
}

public void takeBabies(Organism x)
{
    babieList.add(x);
}

public void addBabies()
{
    for(Organism x: babieList)
        organisms.add(x);
}


}